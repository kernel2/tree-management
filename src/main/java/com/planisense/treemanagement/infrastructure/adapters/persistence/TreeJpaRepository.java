package com.planisense.treemanagement.infrastructure.adapters.persistence;

import com.planisense.treemanagement.application.dto.ArrondissementTreeCountDTO;
import com.planisense.treemanagement.application.dto.GenreTreeCountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeJpaRepository extends JpaRepository<TreeEntity, Long> {
    Page<TreeEntity> findAll(Pageable pageable);

    @Query("SELECT te.arrondissement, COUNT(te) FROM TreeEntity te WHERE (:arrondissement IS NULL OR te.arrondissement = :arrondissement) GROUP BY te.arrondissement")
    List<Object[]> getArrondissementWithTreeCount(@Param("arrondissement") String arrondissement);


    @Query("SELECT te FROM TreeEntity te WHERE (:arrondissement IS NULL OR te.arrondissement = :arrondissement)")
    List<TreeEntity> getTreesGroupedByArrondissement(@Param("arrondissement") String arrondissement);

    @Query("SELECT te.genre, COUNT(te) FROM TreeEntity te WHERE (:genre IS NULL OR te.genre = :genre) GROUP BY te.genre")
    List<Object[]> getGenreWithTreeCount(@Param("genre") String genre);


}
