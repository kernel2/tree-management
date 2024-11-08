package com.planisense.treemanagement.infrastructure.adapters.persistence;

import com.planisense.treemanagement.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TreeRepositoryAdapterTest {

    @Mock
    private TreeJpaRepository treeJpaRepository;

    @Mock
    private TreeMapper treeMapper;

    @InjectMocks
    private TreeRepositoryAdapter treeRepositoryAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllPaginated() {
        TreeEntity treeEntity = new TreeEntity();
        Tree tree = new Tree(1L, "Arbre", "Jardin", "PARIS 12E ARRDT", "Main Street", "100",
                "Park Avenue", "A001", "Oak", "Quercus", "robur", "English Oak", 50, 10, "Mature", false,
                new GeoPoint(2.3, 48.8));
        List<TreeEntity> treeEntities = List.of(treeEntity);
        Page<TreeEntity> treePage = new PageImpl<>(treeEntities, PageRequest.of(0, 10), 1);

        when(treeJpaRepository.findAll(any(PageRequest.class))).thenReturn(treePage);
        when(treeMapper.toDomainModel(treeEntity)).thenReturn(tree);

        PaginatedResult<Tree> result = treeRepositoryAdapter.findAllPaginated(new PaginationRequest(0, 10));

        assertEquals(1, result.totalElements());
        assertEquals(1, result.totalPages());
        assertEquals(tree, result.content().get(0));
    }

    @Test
    void testGetTreesGroupedByArrondissement() {
        String arrondissement = "PARIS 12E ARRDT";
        Object[] countData = {arrondissement, 100L};
        List<Object[]> countDataList = new ArrayList<>();
        countDataList.add(countData);

        TreeEntity treeEntity = new TreeEntity();
        Tree tree = new Tree(1L, "Arbre", "Jardin", arrondissement, "Main Street", "100",
                "Park Avenue", "A001", "Oak", "Quercus", "robur", "English Oak", 50, 10, "Mature", false,
                new GeoPoint(2.3, 48.8));

        when(treeJpaRepository.getArrondissementWithTreeCount(arrondissement)).thenReturn(countDataList);
        when(treeJpaRepository.getTreesGroupedByArrondissement(arrondissement)).thenReturn(List.of(treeEntity));
        when(treeMapper.toDomainModel(treeEntity)).thenReturn(tree);

        List<ArrondissementTreeCount> result = treeRepositoryAdapter.getTreesGroupedByArrondissement(arrondissement);

        assertEquals(1, result.size());
        assertEquals(arrondissement, result.get(0).getArrondissement());
        assertEquals(100L, result.get(0).getTreeCount());
    }

    @Test
    void testFindGenreTreeCounts() {
        String genre = "Quercus";
        Object[] countData = {genre, 50L};
        List<Object[]> countDataList = new ArrayList<>();
        countDataList.add(countData);

        TreeEntity treeEntity = new TreeEntity();
        Tree tree = new Tree(1L, "Arbre", "Jardin", "PARIS 12E ARRDT", "Main Street", "100",
                "Park Avenue", "A001", "Oak", genre, "robur", "English Oak", 50, 10, "Mature", false,
                new GeoPoint(2.3, 48.8));

        when(treeJpaRepository.getGenreWithTreeCount(genre)).thenReturn(countDataList);
        when(treeJpaRepository.findAll()).thenReturn(List.of(treeEntity));
        when(treeMapper.toDomainModel(treeEntity)).thenReturn(tree);

        List<GenreTreeCount> result = treeRepositoryAdapter.findGenreTreeCounts(genre);

        assertEquals(1, result.size());
        assertEquals(genre, result.get(0).getGenre());
        assertEquals(50L, result.get(0).getTreeCount());
    }
}
