package com.planisense.treemanagement.infrastructure.adapters.persistence;

import com.planisense.treemanagement.application.dto.GenreTreeCountDTO;
import com.planisense.treemanagement.domain.model.GenreTreeCount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface GenreTreeCountMapper {
    GenreTreeCountMapper INSTANCE = Mappers.getMapper(GenreTreeCountMapper.class);

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
