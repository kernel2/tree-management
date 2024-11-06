package com.planisense.treemanagement.domain.services;

import com.planisense.treemanagement.domain.model.Tree;
import com.planisense.treemanagement.domain.ports.TreeRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TreeServiceImpl {

    private final TreeRepositoryPort treeRepositoryPort;

    public TreeServiceImpl(TreeRepositoryPort treeRepositoryPort) {
        this.treeRepositoryPort = treeRepositoryPort;
    }

    public Page<Tree> findAllPaginated(Pageable pageable) {
        return treeRepositoryPort.findAllPaginated(pageable);
    }
}
