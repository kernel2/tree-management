package com.planisense.treemanagement.application.services;

import com.planisense.treemanagement.application.dto.ArrondissementTreeCountDTO;
import com.planisense.treemanagement.application.dto.GenreTreeCountDTO;
import com.planisense.treemanagement.application.dto.TreeDTO;
import com.planisense.treemanagement.domain.model.*;
import com.planisense.treemanagement.domain.services.TreeServiceImpl;
import com.planisense.treemanagement.infrastructure.adapters.persistence.ArrondissementTreeCountMapper;
import com.planisense.treemanagement.infrastructure.adapters.persistence.GenreTreeCountMapper;
import com.planisense.treemanagement.infrastructure.adapters.persistence.TreeMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TreeAppServiceTest {

    @Mock
    private TreeServiceImpl treeService;

    @Mock
    private TreeMapper treeMapper;

    @Mock
    private ArrondissementTreeCountMapper arrondissementTreeCountMapper;

    @Mock
    private GenreTreeCountMapper genreTreeCountMapper;

    @InjectMocks
    private TreeAppService treeAppService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTreesPaginated() {
        PaginationRequest paginationRequest = new PaginationRequest(0, 10);
        Tree tree = new Tree(1L, "Arbre", "Jardin", "PARIS 12E ARRDT", "Main Street", "100",
                "Park Avenue", "A001", "Oak", "Quercus", "robur", "English Oak", 50, 10, "Mature", false,
                new GeoPoint(2.3, 48.8));
        TreeDTO treeDTO = new TreeDTO();

        PaginatedResult<Tree> paginatedTrees = new PaginatedResult<>(List.of(tree), 1, 1);
        when(treeService.findAllPaginated(any(PaginationRequest.class))).thenReturn(paginatedTrees);
        when(treeMapper.mapToDTO(tree)).thenReturn(treeDTO);

        PaginatedResult<TreeDTO> result = treeAppService.getAllTreesPaginated(0, 10);

        assertEquals(1, result.totalPages());
        assertEquals(1, result.totalElements());
        assertEquals(1, result.content().size());
        assertEquals(treeDTO, result.content().get(0));
    }

    @Test
    void testGetArrondissementTreeCounts() {
        // Arrange
        String arrondissement = "PARIS 12E ARRDT";
        ArrondissementTreeCount arrondissementTreeCount = new ArrondissementTreeCount(arrondissement, 100L, List.of());
        ArrondissementTreeCountDTO arrondissementTreeCountDTO = new ArrondissementTreeCountDTO(arrondissement, 100L, List.of());

        when(treeService.findArrondissementTreeCounts(arrondissement)).thenReturn(List.of(arrondissementTreeCount));
        when(arrondissementTreeCountMapper.toDTO(arrondissementTreeCount)).thenReturn(arrondissementTreeCountDTO);

        List<ArrondissementTreeCountDTO> result = treeAppService.getArrondissementTreeCounts(arrondissement);

        assertEquals(1, result.size());
        assertEquals(arrondissementTreeCountDTO, result.get(0));
    }

    @Test
    void testGetGenreTreeCounts() {
        String genre = "Quercus";
        GenreTreeCount genreTreeCount = new GenreTreeCount(genre, 50L, List.of());
        GenreTreeCountDTO genreTreeCountDTO = new GenreTreeCountDTO(genre, 50L, List.of());

        when(treeService.findGenreTreeCounts(genre)).thenReturn(List.of(genreTreeCount));
        when(genreTreeCountMapper.toDTO(genreTreeCount)).thenReturn(genreTreeCountDTO);

        List<GenreTreeCountDTO> result = treeAppService.getGenreTreeCounts(genre);

        assertEquals(1, result.size());
        assertEquals(genreTreeCountDTO, result.get(0));
    }
}
