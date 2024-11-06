package com.planisense.treemanagement.infrastructure.adapters.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeJpaRepository extends JpaRepository<TreeEntity, Long> {
    Page<TreeEntity> findAll(Pageable pageable);
}
