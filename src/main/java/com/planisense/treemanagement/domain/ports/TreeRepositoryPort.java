package com.planisense.treemanagement.domain.ports;


import com.planisense.treemanagement.domain.model.PaginatedResult;
import com.planisense.treemanagement.domain.model.PaginationRequest;
import com.planisense.treemanagement.domain.model.Tree;

public interface TreeRepositoryPort {
    PaginatedResult<Tree> findAllPaginated(PaginationRequest paginationRequest);
}