package com.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ville
{
    private String insee;
    private String nom;
    private String codePostal;
    private String libelle;
    private String ligne;
    private Coordonnees coord;
    
    @JsonCreator
    public Ville(@JsonProperty("insee") final String insee, @JsonProperty("nom") final String nom, @JsonProperty("codePostal") final String code, @JsonProperty("libelle") final String libelle, @JsonProperty("ligne") final String ligne, @JsonProperty("coordonnees") final Coordonnees coord) {
        this.insee = insee;
        this.nom = nom;
        this.codePostal = code;
        this.libelle = libelle;
        this.ligne = ligne;
        this.coord = coord;
    }
    
    public String getInsee() {
        return this.insee;
    }
    
    public void setInsee(final String insee) {
        this.insee = insee;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(final String nom) {
        this.nom = nom;
    }
    
    public String getCodePostal() {
        return this.codePostal;
    }
    
    public void setCodePostal(final String codePostal) {
        this.codePostal = codePostal;
    }
    
    public String getLibelle() {
        return this.libelle;
    }
    
    public void setLibelle(final String libelle) {
        this.libelle = libelle;
    }
    
    public String getLigne() {
        return this.ligne;
    }
    
    public void setLigne(final String ligne) {
        this.ligne = ligne;
    }
    
    public Coordonnees getCoord() {
        return this.coord;
    }
    
    public void setCoord(final Coordonnees coord) {
        this.coord = coord;
    }
}
