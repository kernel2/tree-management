package com.planisense.treemanagement.domain.ports;


import com.planisense.treemanagement.domain.model.*;

import java.util.List;

public interface TreeRepositoryPort {
    PaginatedResult<Tree> findAllPaginated(PaginationRequest paginationRequest);

    List<ArrondissementTreeCount> getTreesGroupedByArrondissement(String arrondissement);

    List<GenreTreeCount> findGenreTreeCounts(String genre);
}