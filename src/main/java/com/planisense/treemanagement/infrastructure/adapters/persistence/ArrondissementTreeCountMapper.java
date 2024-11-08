package com.planisense.treemanagement.infrastructure.adapters.persistence;

import com.planisense.treemanagement.application.dto.ArrondissementTreeCountDTO;
import com.planisense.treemanagement.application.dto.TreeDTO;
import com.planisense.treemanagement.domain.model.ArrondissementTreeCount;
import com.planisense.treemanagement.domain.model.Tree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ArrondissementTreeCountMapper {

    @Autowired
    private TreeMapper treeMapper;

    @Mapping(target = "trees", expression = "java(mapTreeList(arrondissementTreeCount.getTrees()))")
    public abstract ArrondissementTreeCountDTO toDTO(ArrondissementTreeCount arrondissementTreeCount);

    protected List<TreeDTO> mapTreeList(List<Tree> trees) {
        return trees.stream().map(treeMapper::mapToDTO).collect(Collectors.toList());
    }
}