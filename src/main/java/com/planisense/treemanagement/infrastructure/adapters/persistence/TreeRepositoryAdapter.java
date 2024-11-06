package com.planisense.treemanagement.infrastructure.adapters.persistence;

import com.planisense.treemanagement.application.dto.TreeDTO;
import com.planisense.treemanagement.domain.model.Tree;
import com.planisense.treemanagement.domain.ports.TreeRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    public Page<Tree> findAllPaginated(Pageable pageable) {
        return treeJpaRepository.findAll(pageable).map(treeMapper::toDomainModel);
    }
}
