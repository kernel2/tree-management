package com.planisense.treemanagement.infrastructure.adapters.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

@Entity
public class TreeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("idbase")
    private Long idBase;

    @JsonProperty("typeemplacement")
    private String typeEmplacement;

    private String domanialite;
    private String arrondissement;

    @JsonProperty("complementadresse")
    private String complementAdresse;

    private String numero;

    @JsonProperty("adresse")
    private String lieuAdresse;

    @JsonProperty("idemplacement")
    private String idEmplacement;

    @JsonProperty("libellefrancais")
    private String libelleFrancais;

    private String genre;
    private String espece;

    @JsonProperty("varieteoucultivar")
    private String varieteOuCultivar;

    @JsonProperty("circonferenceencm")
    private Integer circonferenceCm;

    @JsonProperty("hauteurenm")
    private Integer hauteurM;

    @JsonProperty("stadedeveloppement")
    private String stadeDeveloppement;

    @JsonProperty("remarquable")
    @JsonDeserialize(using = BooleanOuiNonDeserializer.class)
    private Boolean remarquable;

    @JsonProperty("geo_point_2d")
    @Embedded
    private GeoPointEntity geoPoint2d;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdBase() {
        return idBase;
    }

    public void setIdBase(Long idBase) {
        this.idBase = idBase;
    }

    public String getTypeEmplacement() {
        return typeEmplacement;
    }

    public void setTypeEmplacement(String typeEmplacement) {
        this.typeEmplacement = typeEmplacement;
    }

    public String getDomanialite() {
        return domanialite;
    }

    public void setDomanialite(String domanialite) {
        this.domanialite = domanialite;
    }

    public String getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(String arrondissement) {
        this.arrondissement = arrondissement;
    }

    public String getComplementAdresse() {
        return complementAdresse;
    }

    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLieuAdresse() {
        return lieuAdresse;
    }

    public void setLieuAdresse(String lieuAdresse) {
        this.lieuAdresse = lieuAdresse;
    }

    public String getIdEmplacement() {
        return idEmplacement;
    }

    public void setIdEmplacement(String idEmplacement) {
        this.idEmplacement = idEmplacement;
    }

    public String getLibelleFrancais() {
        return libelleFrancais;
    }

    public void setLibelleFrancais(String libelleFrancais) {
        this.libelleFrancais = libelleFrancais;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getVarieteOuCultivar() {
        return varieteOuCultivar;
    }

    public void setVarieteOuCultivar(String varieteOuCultivar) {
        this.varieteOuCultivar = varieteOuCultivar;
    }

    public Integer getCirconferenceCm() {
        return circonferenceCm;
    }

    public void setCirconferenceCm(Integer circonferenceCm) {
        this.circonferenceCm = circonferenceCm;
    }

    public Integer getHauteurM() {
        return hauteurM;
    }

    public void setHauteurM(Integer hauteurM) {
        this.hauteurM = hauteurM;
    }

    public String getStadeDeveloppement() {
        return stadeDeveloppement;
    }

    public void setStadeDeveloppement(String stadeDeveloppement) {
        this.stadeDeveloppement = stadeDeveloppement;
    }

    public Boolean getRemarquable() {
        return remarquable;
    }

    public void setRemarquable(Boolean remarquable) {
        this.remarquable = remarquable;
    }

    public GeoPointEntity getGeoPoint2d() {
        return geoPoint2d;
    }

    public void setGeoPoint2d(GeoPointEntity geoPoint2d) {
        this.geoPoint2d = geoPoint2d;
    }

    @Override
    public String toString() {
        return "TreeEntity{" +
                "idBase=" + idBase +
                ", typeEmplacement='" + typeEmplacement + '\'' +
                ", domanialite='" + domanialite + '\'' +
                ", arrondissement='" + arrondissement + '\'' +
                ", complementAdresse='" + complementAdresse + '\'' +
                ", numero='" + numero + '\'' +
                ", lieuAdresse='" + lieuAdresse + '\'' +
                ", idEmplacement='" + idEmplacement + '\'' +
                ", libelleFrancais='" + libelleFrancais + '\'' +
                ", genre='" + genre + '\'' +
                ", espece='" + espece + '\'' +
                ", varieteOuCultivar='" + varieteOuCultivar + '\'' +
                ", circonferenceCm=" + circonferenceCm +
                ", hauteurM=" + hauteurM +
                ", stadeDeveloppement='" + stadeDeveloppement + '\'' +
                ", remarquable=" + remarquable +
                ", geoPoint2d=" + geoPoint2d +
                '}';
    }
}
