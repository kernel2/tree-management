package com.planisense.treemanagement.infrastructure.adapters.persistence;

import com.planisense.treemanagement.application.dto.GenreTreeCountDTO;
import com.planisense.treemanagement.application.dto.TreeDTO;
import com.planisense.treemanagement.domain.model.GenreTreeCount;
import com.planisense.treemanagement.domain.model.Tree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class GenreTreeCountMapper {

    @Autowired
    protected TreeMapper treeMapper;

    @Mapping(target = "trees", expression = "java(mapTreeList(genreTreeCount.getTrees()))")
    public abstract GenreTreeCountDTO toDTO(GenreTreeCount genreTreeCount);

    protected List<TreeDTO> mapTreeList(List<Tree> trees) {
        if (trees == null) {
            return Collections.emptyList();
        }
        return trees.stream()
                .map(tree -> treeMapper.mapToDTO(tree))
                .collect(Collectors.toList());
    }
}