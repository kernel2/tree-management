package com.planisense.treemanagement.domain.services;

import com.planisense.treemanagement.domain.model.ArrondissementTreeCount;
import com.planisense.treemanagement.domain.model.PaginatedResult;
import com.planisense.treemanagement.domain.model.PaginationRequest;
import com.planisense.treemanagement.domain.model.Tree;
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
}
