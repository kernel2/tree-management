package com.planisense.treemanagement.application.services;

import com.planisense.treemanagement.application.dto.TreeDTO;
import com.planisense.treemanagement.domain.ports.TreeRepositoryPort;
import com.planisense.treemanagement.infrastructure.adapters.persistence.TreeMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TreeAppService {

    private final TreeRepositoryPort treeRepository;
    private final TreeMapper treeMapper;

    public TreeAppService(TreeRepositoryPort treeRepository, TreeMapper treeMapper) {
        this.treeRepository = treeRepository;
        this.treeMapper = treeMapper;
    }

    public Page<TreeDTO> getAllTreesPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return treeRepository.findAllPaginated(pageable).map(treeMapper::mapToDTO);
    }
}
