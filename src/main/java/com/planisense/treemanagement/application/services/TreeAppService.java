package com.planisense.treemanagement.application.services;

import com.planisense.treemanagement.application.dto.ArrondissementTreeCountDTO;
import com.planisense.treemanagement.application.dto.TreeDTO;
import com.planisense.treemanagement.domain.model.ArrondissementTreeCount;
import com.planisense.treemanagement.domain.model.PaginatedResult;
import com.planisense.treemanagement.domain.model.PaginationRequest;
import com.planisense.treemanagement.domain.model.Tree;
import com.planisense.treemanagement.domain.services.TreeServiceImpl;
import com.planisense.treemanagement.infrastructure.adapters.persistence.ArrondissementTreeCountMapper;
import com.planisense.treemanagement.infrastructure.adapters.persistence.TreeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreeAppService {

    private final TreeServiceImpl treeService;
    private final TreeMapper treeMapper;
    private final ArrondissementTreeCountMapper arrondissementTreeCountMapper;

    public TreeAppService(TreeServiceImpl treeService, TreeMapper treeMapper, ArrondissementTreeCountMapper arrondissementTreeCountMapper) {
        this.treeService = treeService;
        this.treeMapper = treeMapper;
        this.arrondissementTreeCountMapper = arrondissementTreeCountMapper;
    }

    public PaginatedResult<TreeDTO> getAllTreesPaginated(int page, int size) {
        PaginationRequest paginationRequest = new PaginationRequest(page, size);
        PaginatedResult<Tree> paginatedTrees = treeService.findAllPaginated(paginationRequest);

        List<TreeDTO> treesDTOList = paginatedTrees.content().stream()
                .map(treeMapper::mapToDTO)
                .collect(Collectors.toList());

        return new PaginatedResult<>(
                treesDTOList,
                paginatedTrees.totalPages(),
                paginatedTrees.totalElements()
        );
    }

    public List<ArrondissementTreeCountDTO> getArrondissementTreeCounts(String arrondissement) {
        List<ArrondissementTreeCount> counts = treeService.findArrondissementTreeCounts(arrondissement);
        return counts.stream()
                .map(arrondissementTreeCountMapper::toDTO)
                .collect(Collectors.toList());
    }


}

