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



    @Query("SELECT new com.planisense.treemanagement.application.dto.GenreTreeCountDTO(t.genre, COUNT(t)) " +
            "FROM TreeEntity t " +
            "WHERE (:genre IS NULL OR t.genre = :genre) " +
            "GROUP BY t.genre")
    List<GenreTreeCountDTO> countTreesByGenre(@Param("genre") String genre);
}
