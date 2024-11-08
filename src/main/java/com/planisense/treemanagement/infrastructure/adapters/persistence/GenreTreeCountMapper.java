package com.planisense.treemanagement.infrastructure.adapters.persistence;

import com.planisense.treemanagement.application.dto.GenreTreeCountDTO;
import com.planisense.treemanagement.domain.model.GenreTreeCount;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface GenreTreeCountMapper {

    default GenreTreeCountDTO toDTO(GenreTreeCount entity) {
        if (entity == null) {
            return null;
        }
        return new GenreTreeCountDTO(entity.genre(), entity.treeCount());
    }

    default GenreTreeCount toEntity(GenreTreeCountDTO dto) {
        if (dto == null) {
            return null;
        }
        return new GenreTreeCount(dto.getGenre(), dto.getTreeCount());
    }

    default List<GenreTreeCountDTO> toDTOList(List<GenreTreeCount> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
