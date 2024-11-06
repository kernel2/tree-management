package com.planisense.treemanagement.domain.model;

public record Tree(Long idBase, String typeEmplacement, String domanialite, String arrondissement, String complementAdresse,
                   String numero, String lieuAdresse, String idEmplacement, String libelleFrancais, String genre,
                   String espece, String varieteOuCultivar, Integer circonferenceCm, Integer hauteurM,
                   String stadeDeveloppement, Boolean remarquable, GeoPoint geoPoint2d) {
}