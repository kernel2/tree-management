package com.planisense.treemanagement.domain.services;

import com.planisense.treemanagement.domain.model.*;
import com.planisense.treemanagement.domain.ports.TreeRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TreeServiceImplTest {

    @Mock
    private TreeRepositoryPort treeRepositoryPort;

    @InjectMocks
    private TreeServiceImpl treeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllPaginated() {
        // Arrange
        PaginationRequest paginationRequest = new PaginationRequest(0, 10);
        Tree tree = new Tree(1L, "Arbre", "Jardin", "PARIS 12E ARRDT", "Main Street", "100",
                "Park Avenue", "A001", "Oak", "Quercus", "robur", "English Oak", 50, 10, "Mature", false,
                new GeoPoint(2.3, 48.8));

        PaginatedResult<Tree> expectedPaginatedResult = new PaginatedResult<>(List.of(tree), 1, 1);
        when(treeRepositoryPort.findAllPaginated(any(PaginationRequest.class))).thenReturn(expectedPaginatedResult);

        // Act
        PaginatedResult<Tree> result = treeService.findAllPaginated(paginationRequest);

        // Assert
        assertEquals(1, result.totalPages());
        assertEquals(1, result.totalElements());
        assertEquals(1, result.content().size());
        assertEquals(tree, result.content().get(0));
    }

    @Test
    void testFindArrondissementTreeCounts() {
        // Arrange
        String arrondissement = "PARIS 12E ARRDT";
        ArrondissementTreeCount arrondissementTreeCount = new ArrondissementTreeCount(arrondissement, 100L, List.of(
                new Tree(1L, "Arbre", "Jardin", arrondissement, "Main Street", "100", "Park Avenue", "A001",
                        "Oak", "Quercus", "robur", "English Oak", 50, 10, "Mature", false,
                        new GeoPoint(2.3, 48.8))
        ));

        when(treeRepositoryPort.getTreesGroupedByArrondissement(arrondissement)).thenReturn(List.of(arrondissementTreeCount));

        // Act
        List<ArrondissementTreeCount> result = treeService.findArrondissementTreeCounts(arrondissement);

        // Assert
        assertEquals(1, result.size());
        assertEquals(arrondissementTreeCount, result.get(0));
    }

    @Test
    void testFindGenreTreeCounts() {
        // Arrange
        String genre = "Quercus";
        GenreTreeCount genreTreeCount = new GenreTreeCount(genre, 50L, List.of(
                new Tree(1L, "Arbre", "Jardin", "PARIS 12E ARRDT", "Main Street", "100", "Park Avenue", "A001",
                        "Oak", genre, "robur", "English Oak", 50, 10, "Mature", false,
                        new GeoPoint(2.3, 48.8))
        ));

        when(treeRepositoryPort.findGenreTreeCounts(genre)).thenReturn(List.of(genreTreeCount));

        // Act
        List<GenreTreeCount> result = treeService.findGenreTreeCounts(genre);

        // Assert
        assertEquals(1, result.size());
        assertEquals(genreTreeCount, result.get(0));
    }
}
