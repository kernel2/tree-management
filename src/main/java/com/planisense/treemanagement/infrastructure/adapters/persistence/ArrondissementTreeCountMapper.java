package com.planisense.treemanagement.infrastructure.adapters.persistence;

import com.planisense.treemanagement.application.dto.ArrondissementTreeCountDTO;
import com.planisense.treemanagement.domain.model.ArrondissementTreeCount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ArrondissementTreeCountMapper {
    ArrondissementTreeCountMapper INSTANCE = Mappers.getMapper(ArrondissementTreeCountMapper.class);

    default ArrondissementTreeCountDTO toDTO(ArrondissementTreeCount arrondissementTreeCount) {
        if (arrondissementTreeCount == null) {
            return null;
        }
        return new ArrondissementTreeCountDTO(arrondissementTreeCount.arrondissement(), arrondissementTreeCount.treeCount());
    }

    default ArrondissementTreeCount toEntity(ArrondissementTreeCountDTO dto) {
        if (dto == null) {
            return null;
        }
        return new ArrondissementTreeCount(dto.getArrondissement(), dto.getTreeCount());
    }

    default List<ArrondissementTreeCountDTO> toDTOList(List<ArrondissementTreeCount> arrondissementTreeCountList) {
        return arrondissementTreeCountList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
