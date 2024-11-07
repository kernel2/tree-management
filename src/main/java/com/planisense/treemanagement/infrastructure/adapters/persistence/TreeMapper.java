package com.planisense.treemanagement.infrastructure.adapters.persistence;

import com.planisense.treemanagement.application.dto.GeoPointDTO;
import com.planisense.treemanagement.application.dto.TreeDTO;
import com.planisense.treemanagement.domain.model.Tree;
import com.planisense.treemanagement.domain.model.GeoPoint;
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
public interface TreeMapper {

    default TreeDTO mapToDTO(Tree tree) {
        if (tree == null) {
            return null;
        }

        TreeDTO dto = new TreeDTO();
        dto.setIdbase(tree.idBase());
        dto.setTypeemplacement(tree.typeEmplacement());
        dto.setDomanialite(tree.domanialite());
        dto.setArrondissement(tree.arrondissement());
        dto.setComplementadresse(tree.complementAdresse());
        dto.setNumero(tree.numero());
        dto.setAdresse(tree.lieuAdresse());
        dto.setIdemplacement(tree.idEmplacement());
        dto.setLibellefrancais(tree.libelleFrancais());
        dto.setGenre(tree.genre());
        dto.setEspece(tree.espece());
        dto.setVarieteoucultivar(tree.varieteOuCultivar());
        dto.setCirconferenceencm(tree.circonferenceCm());
        dto.setHauteurenm(tree.hauteurM());
        dto.setStadedeveloppement(tree.stadeDeveloppement());
        dto.setRemarquable(tree.remarquable() != null ? (tree.remarquable() ? "OUI" : "NON") : null);

        if (tree.geoPoint2d() != null) {
            GeoPointDTO geoPointDTO = new GeoPointDTO();
            geoPointDTO.setLon(tree.geoPoint2d().longitude());
            geoPointDTO.setLat(tree.geoPoint2d().latitude());
            dto.setGeoPoint2d(geoPointDTO);
        }

        return dto;
    }

    default Tree toDomainModel(TreeEntity entity) {
        if (entity == null) {
            return null;
        }

        GeoPoint geoPoint = null;
        if (entity.getGeoPoint2d() != null) {
            geoPoint = new GeoPoint(
                    entity.getGeoPoint2d().getLon(),
                    entity.getGeoPoint2d().getLat()
            );
        }

        return new Tree(
                entity.getIdBase(),
                entity.getTypeEmplacement(),
                entity.getDomanialite(),
                entity.getArrondissement(),
                entity.getComplementAdresse(),
                entity.getNumero(),
                entity.getLieuAdresse(),
                entity.getIdEmplacement(),
                entity.getLibelleFrancais(),
                entity.getGenre(),
                entity.getEspece(),
                entity.getVarieteOuCultivar(),
                entity.getCirconferenceCm(),
                entity.getHauteurM(),
                entity.getStadeDeveloppement(),
                entity.getRemarquable(),
                geoPoint
        );
    }

    default List<TreeDTO> toDTOList(List<Tree> trees) {
        return trees.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    default List<Tree> toDomainModelList(List<TreeEntity> entities) {
        return entities.stream()
                .map(this::toDomainModel)
                .collect(Collectors.toList());
    }
}
