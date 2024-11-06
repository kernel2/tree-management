package com.planisense.treemanagement.application.dto;

public class GeoPointDTO {
    private Double lon;
    private Double lat;

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "GeoPointDTO{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
