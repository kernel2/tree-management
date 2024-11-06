package com.planisense.treemanagement.infrastructure.adapters.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;

@Embeddable
public class GeoPointEntity {

    @JsonProperty("lon")
    private Double lon;

    @JsonProperty("lat")
    private Double lat;

    public GeoPointEntity() {}

    public GeoPointEntity(Double lon, Double lat) {
        this.lon = lon;
        this.lat = lat;
    }

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
        return "GeoPointEntity{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
