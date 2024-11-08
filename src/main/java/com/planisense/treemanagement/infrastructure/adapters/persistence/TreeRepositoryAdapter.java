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

    public TreeRepositoryAdapter(TreeJpaRepository treeJpaRepository, TreeMapper treeMapper) {
        this.treeJpaRepository = treeJpaRepository;
        this.treeMapper = treeMapper;
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
        List<Object[]> genreCounts = treeJpaRepository.getGenreWithTreeCount(genre);

        List<TreeEntity> allTrees = treeJpaRepository.findAll();
        Map<String, List<Tree>> treesByGenre = allTrees.stream()
                .filter(treeEntity -> treeEntity.getGenre() != null) // Exclude null genres to avoid mapping issues
                .collect(Collectors.groupingBy(
                        TreeEntity::getGenre,
                        Collectors.mapping(treeMapper::toDomainModel, Collectors.toList())
                ));

        return genreCounts.stream()
                .map(countResult -> {
                    String genreName = (String) countResult[0];
                    Long treeCount = (Long) countResult[1];
                    List<Tree> trees = treesByGenre.getOrDefault(genreName, List.of());
                    return new GenreTreeCount(genreName, treeCount, trees);
                })
                .collect(Collectors.toList());
    }
}
