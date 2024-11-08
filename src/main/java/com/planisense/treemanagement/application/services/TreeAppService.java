package com.planisense.treemanagement.application.services;

import com.planisense.treemanagement.application.dto.ArrondissementTreeCountDTO;
import com.planisense.treemanagement.application.dto.GenreTreeCountDTO;
import com.planisense.treemanagement.application.dto.TreeDTO;
import com.planisense.treemanagement.domain.model.*;
import com.planisense.treemanagement.domain.services.TreeServiceImpl;
import com.planisense.treemanagement.infrastructure.adapters.persistence.ArrondissementTreeCountMapper;
import com.planisense.treemanagement.infrastructure.adapters.persistence.GenreTreeCountMapper;
import com.planisense.treemanagement.infrastructure.adapters.persistence.TreeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreeAppService {

    private final TreeServiceImpl treeService;
    private final TreeMapper treeMapper;
    private final ArrondissementTreeCountMapper arrondissementTreeCountMapper;
    private final GenreTreeCountMapper genreTreeCountMapper;

    public TreeAppService(TreeServiceImpl treeService, TreeMapper treeMapper, ArrondissementTreeCountMapper arrondissementTreeCountMapper, GenreTreeCountMapper genreTreeCountMapper) {
        this.treeService = treeService;
        this.treeMapper = treeMapper;
        this.arrondissementTreeCountMapper = arrondissementTreeCountMapper;
        this.genreTreeCountMapper = genreTreeCountMapper;
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

    public List<GenreTreeCountDTO> getGenreTreeCounts(String genre) {
        List<GenreTreeCount> counts = treeService.findGenreTreeCounts(genre);
        return counts.stream()
                .map(genreTreeCountMapper::toDTO)
                .collect(Collectors.toList());
    }

}

