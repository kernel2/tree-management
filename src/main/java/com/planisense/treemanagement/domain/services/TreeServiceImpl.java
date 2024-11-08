package com.planisense.treemanagement.domain.services;

import com.planisense.treemanagement.domain.model.*;
import com.planisense.treemanagement.domain.ports.TreeRepositoryPort;

import java.util.List;

public class TreeServiceImpl {

    private final TreeRepositoryPort treeRepositoryPort;

    public TreeServiceImpl(TreeRepositoryPort treeRepositoryPort) {
        this.treeRepositoryPort = treeRepositoryPort;
    }

    public PaginatedResult<Tree> findAllPaginated(PaginationRequest paginationRequest) {
        return treeRepositoryPort.findAllPaginated(paginationRequest);
    }

    public List<ArrondissementTreeCount> findArrondissementTreeCounts(String arrondissement) {
        return treeRepositoryPort.getTreesGroupedByArrondissement(arrondissement);
    }

    public List<GenreTreeCount> findGenreTreeCounts(String genre) {
        return treeRepositoryPort.findGenreTreeCounts(genre);
    }
}
