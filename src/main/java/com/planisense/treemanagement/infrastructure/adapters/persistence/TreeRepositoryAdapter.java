package com.planisense.treemanagement.infrastructure.adapters.persistence;

import com.planisense.treemanagement.domain.model.*;
import com.planisense.treemanagement.domain.ports.TreeRepositoryPort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Transactional
public class TreeRepositoryAdapter implements TreeRepositoryPort {

    private final TreeJpaRepository treeJpaRepository;
    private final TreeMapper treeMapper;
    private final GenreTreeCountMapper genreTreeCountMapper;

    public TreeRepositoryAdapter(TreeJpaRepository treeJpaRepository, TreeMapper treeMapper, GenreTreeCountMapper genreTreeCountMapper) {
        this.treeJpaRepository = treeJpaRepository;
        this.treeMapper = treeMapper;
        this.genreTreeCountMapper = genreTreeCountMapper;
    }

    @Override
    public PaginatedResult<Tree> findAllPaginated(PaginationRequest paginationRequest) {
        Pageable pageable = PageRequest.of(paginationRequest.page(), paginationRequest.size());
        var treePage = treeJpaRepository.findAll(pageable);

        return new PaginatedResult<>(
                treePage.getContent().stream().map(treeMapper::toDomainModel).collect(Collectors.toList()),
                treePage.getTotalPages(),
                treePage.getTotalElements()
        );
    }

    @Override
    public List<ArrondissementTreeCount> getTreesGroupedByArrondissement(String arrondissement) {
        List<Object[]> arrondissementCounts = treeJpaRepository.getArrondissementWithTreeCount(arrondissement);

        List<TreeEntity> allTrees = treeJpaRepository.getTreesGroupedByArrondissement(arrondissement);

        Map<String, List<Tree>> treesByArrondissement = allTrees.stream()
                .collect(Collectors.groupingBy(
                        TreeEntity::getArrondissement,
                        Collectors.mapping(treeMapper::toDomainModel, Collectors.toList())
                ));

        return arrondissementCounts.stream()
                .map(countResult -> {
                    String arr = (String) countResult[0];
                    Long treeCount = (Long) countResult[1];
                    List<Tree> trees = treesByArrondissement.getOrDefault(arr, List.of());
                    return new ArrondissementTreeCount(arr, treeCount, trees);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<GenreTreeCount> findGenreTreeCounts(String genre) {
        return treeJpaRepository.countTreesByGenre(genre).stream().map(genreTreeCountMapper::toEntity).toList();
    }
}
