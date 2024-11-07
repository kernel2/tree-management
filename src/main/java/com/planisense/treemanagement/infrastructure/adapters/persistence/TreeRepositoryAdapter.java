package com.planisense.treemanagement.infrastructure.adapters.persistence;

import com.planisense.treemanagement.domain.model.PaginatedResult;
import com.planisense.treemanagement.domain.model.PaginationRequest;
import com.planisense.treemanagement.domain.model.Tree;
import com.planisense.treemanagement.domain.ports.TreeRepositoryPort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
}
