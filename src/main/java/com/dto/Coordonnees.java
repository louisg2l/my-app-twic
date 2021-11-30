package com.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordonnees
{
    private String longitude;
    private String latitude;
    
    public Coordonnees(@JsonProperty("latitude") final String latitude, @JsonProperty("longitude") final String longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
    
    public String getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(final String longitude) {
        this.longitude = longitude;
    }
    
    public String getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(final String latitude) {
        this.latitude = latitude;
    }
}
