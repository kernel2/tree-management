package com.planisense.treemanagement.infrastructure.adapters.rest;

import com.planisense.treemanagement.application.dto.ArrondissementTreeCountDTO;
import com.planisense.treemanagement.application.dto.TreeDTO;
import com.planisense.treemanagement.application.services.TreeAppService;
import com.planisense.treemanagement.domain.model.PaginatedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trees")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TreeController {

    private final TreeAppService treeAppService;

    @Autowired
    public TreeController(TreeAppService treeAppService) {
        this.treeAppService = treeAppService;
    }

    @GetMapping
    public ResponseEntity<PaginatedResult<TreeDTO>> getAllTrees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size) {
        PaginatedResult<TreeDTO> treesPage = treeAppService.getAllTreesPaginated(page, size);
        return ResponseEntity.ok(treesPage);
    }

    @GetMapping("/arrondissement-count")
    public ResponseEntity<List<ArrondissementTreeCountDTO>> getArrondissementTreeCounts(
            @RequestParam(required = false) String arrondissement) {
        List<ArrondissementTreeCountDTO> arrondissementTreeCounts = treeAppService.getArrondissementTreeCounts(arrondissement);
        return ResponseEntity.ok(arrondissementTreeCounts);
    }
}
