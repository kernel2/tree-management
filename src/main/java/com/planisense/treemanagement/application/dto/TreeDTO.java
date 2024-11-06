package com.planisense.treemanagement.application.dto;

public class TreeDTO {
    private Long idbase;
    private String typeemplacement;
    private String domanialite;
    private String arrondissement;
    private String complementadresse;
    private String numero;
    private String adresse;
    private String idemplacement;
    private String libellefrancais;
    private String genre;
    private String espece;
    private String varieteoucultivar;
    private Integer circonferenceencm;
    private Integer hauteurenm;
    private String stadedeveloppement;
    private String remarquable;
    private GeoPointDTO geoPoint2d;

    public Long getIdbase() {
        return idbase;
    }

    public void setIdbase(Long idbase) {
        this.idbase = idbase;
    }

    public String getTypeemplacement() {
        return typeemplacement;
    }

    public void setTypeemplacement(String typeemplacement) {
        this.typeemplacement = typeemplacement;
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

    public String getComplementadresse() {
        return complementadresse;
    }

    public void setComplementadresse(String complementadresse) {
        this.complementadresse = complementadresse;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getIdemplacement() {
        return idemplacement;
    }

    public void setIdemplacement(String idemplacement) {
        this.idemplacement = idemplacement;
    }

    public String getLibellefrancais() {
        return libellefrancais;
    }

    public void setLibellefrancais(String libellefrancais) {
        this.libellefrancais = libellefrancais;
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

    public String getVarieteoucultivar() {
        return varieteoucultivar;
    }

    public void setVarieteoucultivar(String varieteoucultivar) {
        this.varieteoucultivar = varieteoucultivar;
    }

    public Integer getCirconferenceencm() {
        return circonferenceencm;
    }

    public void setCirconferenceencm(Integer circonferenceencm) {
        this.circonferenceencm = circonferenceencm;
    }

    public Integer getHauteurenm() {
        return hauteurenm;
    }

    public void setHauteurenm(Integer hauteurenm) {
        this.hauteurenm = hauteurenm;
    }

    public String getStadedeveloppement() {
        return stadedeveloppement;
    }

    public void setStadedeveloppement(String stadedeveloppement) {
        this.stadedeveloppement = stadedeveloppement;
    }

    public String getRemarquable() {
        return remarquable;
    }

    public void setRemarquable(String remarquable) {
        this.remarquable = remarquable;
    }

    public GeoPointDTO getGeoPoint2d() {
        return geoPoint2d;
    }

    public void setGeoPoint2d(GeoPointDTO geoPoint2d) {
        this.geoPoint2d = geoPoint2d;
    }

    @Override
    public String toString() {
        return "TreeDTO{" +
                "idbase=" + idbase +
                ", typeemplacement='" + typeemplacement + '\'' +
                ", domanialite='" + domanialite + '\'' +
                ", arrondissement='" + arrondissement + '\'' +
                ", complementadresse='" + complementadresse + '\'' +
                ", numero='" + numero + '\'' +
                ", adresse='" + adresse + '\'' +
                ", idemplacement='" + idemplacement + '\'' +
                ", libellefrancais='" + libellefrancais + '\'' +
                ", genre='" + genre + '\'' +
                ", espece='" + espece + '\'' +
                ", varieteoucultivar='" + varieteoucultivar + '\'' +
                ", circonferenceencm=" + circonferenceencm +
                ", hauteurenm=" + hauteurenm +
                ", stadedeveloppement='" + stadedeveloppement + '\'' +
                ", remarquable='" + remarquable + '\'' +
                ", geo_point_2d=" + geoPoint2d +
                '}';
    }
}
