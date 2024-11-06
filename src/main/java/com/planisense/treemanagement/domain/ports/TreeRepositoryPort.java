package com.planisense.treemanagement.domain.ports;


import com.planisense.treemanagement.domain.model.Tree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TreeRepositoryPort {
    Page<Tree> findAllPaginated(Pageable pageable);
}