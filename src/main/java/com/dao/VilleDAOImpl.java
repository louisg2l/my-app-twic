package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import org.slf4j.LoggerFactory;
import com.dto.Coordonnees;
import com.dto.Ville;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class VilleDAOImpl implements VilleDAO
{
    private Logger logger;
    private Statement st;
    private ResultSet resultat;
    private ArrayList<Ville> liste;
    private Coordonnees coord;
    
    public VilleDAOImpl() {
        this.logger = LoggerFactory.getLogger((Class)VilleDAOImpl.class);
        this.st = null;
        this.resultat = null;
        this.liste = new ArrayList<Ville>();
        this.coord = null;
    }
    
    @Override
    public ArrayList<Ville> findAllVilles() {
        final Connection con = new JDBCConfiguration().getCo();
        this.liste = new ArrayList<Ville>();
        try {
            this.st = con.createStatement();
            this.resultat = this.st.executeQuery("SELECT * FROM ville_france;");
            while (this.resultat.next()) {
                this.coord = new Coordonnees(this.resultat.getString("Latitude"), this.resultat.getString("Longitude"));
                final Ville ville = new Ville(this.resultat.getString(1), this.resultat.getString(2), this.resultat.getString(3), this.resultat.getString(4), this.resultat.getString(5), this.coord);
                this.liste.add(ville);
            }
            return this.liste;
        }
        catch (SQLException e) {
            this.logger.error("Impossible de r\u00e9aliser la requ\u00eate.", (Throwable)e);
            try {
                this.st.close();
                con.close();
            }
            catch (SQLException e2) {
                this.logger.error("Impossible de se d\u00e9connecter.", (Throwable)e2);
            }
        }
        finally {
            try {
                this.st.close();
                con.close();
            }
            catch (SQLException e2) {
                this.logger.error("Impossible de se d\u00e9connecter.", (Throwable)e2);
            }
        }
        return null;
    }
    
    @Override
    public ArrayList<Ville> getVilleByInsee(final String code) {
        final Connection con = new JDBCConfiguration().getCo();
        this.liste = new ArrayList<Ville>();
        try {
            this.st = con.createStatement();
            this.resultat = this.st.executeQuery("SELECT * FROM ville_france WHERE Code_commune_INSEE='" + code + "';");
            while (this.resultat.next()) {
                this.coord = new Coordonnees(this.resultat.getString("Latitude"), this.resultat.getString("Longitude"));
                final Ville ville = new Ville(this.resultat.getString(1), this.resultat.getString(2), this.resultat.getString(3), this.resultat.getString(4), this.resultat.getString(5), this.coord);
                this.liste.add(ville);
            }
            return this.liste;
        }
        catch (SQLException e) {
            this.logger.error("Impossible de r\u00e9aliser la requ\u00eate.", (Throwable)e);
            try {
                this.st.close();
                con.close();
            }
            catch (SQLException e2) {
                this.logger.error("Impossible de se d\u00e9connecter.", (Throwable)e2);
            }
        }
        finally {
            try {
                this.st.close();
                con.close();
            }
            catch (SQLException e2) {
                this.logger.error("Impossible de se d\u00e9connecter.", (Throwable)e2);
            }
        }
        return null;
    }
    
    @Override
    public void ajouterVille(final Ville ville) {
        final Connection con = new JDBCConfiguration().getCo();
        try {
            (this.st = con.createStatement()).executeUpdate("INSERT INTO `ville_france`(`Code_commune_INSEE`, `Nom_commune`, `Code_postal`, `Libelle_acheminement`, `Ligne_5`, `Latitude`, `Longitude`) VALUES ('" + ville.getInsee() + "','" + ville.getNom() + "','" + ville.getCodePostal() + "','" + ville.getLibelle() + "','" + ville.getLigne() + "','" + ville.getCoord().getLatitude() + "','" + ville.getCoord().getLongitude() + "');");
        }
        catch (SQLException e) {
            this.logger.error("Impossible de r\u00e9aliser la requ\u00eate.", (Throwable)e);
            try {
                this.st.close();
                con.close();
            }
            catch (SQLException e2) {
                this.logger.error("Impossible de se d\u00e9connecter.", (Throwable)e2);
            }
            return;
        }
        finally {
            try {
                this.st.close();
                con.close();
            }
            catch (SQLException e2) {
                this.logger.error("Impossible de se d\u00e9connecter.", (Throwable)e2);
            }
        }
        try {
            this.st.close();
            con.close();
        }
        catch (SQLException e2) {
            this.logger.error("Impossible de se d\u00e9connecter.", (Throwable)e2);
        }
    }
    
    @Override
    public void modifierVille(final Ville ville, final String insee) {
        final Connection con = new JDBCConfiguration().getCo();
        try {
            (this.st = con.createStatement()).executeUpdate("UPDATE ville_france SET Code_commune_INSEE='" + ville.getInsee() + "', Nom_commune ='" + ville.getNom() + "',Code_postal='" + ville.getCodePostal() + "',Libelle_acheminement='" + ville.getLibelle() + "',Ligne_5='" + ville.getLigne() + "',Latitude='" + ville.getCoord().getLatitude() + "',Longitude='" + ville.getCoord().getLongitude() + "' WHERE Code_commune_INSEE='" + insee + "';");
        }
        catch (SQLException e) {
            this.logger.error("Impossible de r\u00e9aliser la requ\u00eate.", (Throwable)e);
            try {
                this.st.close();
                con.close();
            }
            catch (SQLException e2) {
                this.logger.error("Impossible de se d\u00e9connecter.", (Throwable)e2);
            }
            return;
        }
        finally {
            try {
                this.st.close();
                con.close();
            }
            catch (SQLException e2) {
                this.logger.error("Impossible de se d\u00e9connecter.", (Throwable)e2);
            }
        }
        try {
            this.st.close();
            con.close();
        }
        catch (SQLException e2) {
            this.logger.error("Impossible de se d\u00e9connecter.", (Throwable)e2);
        }
    }
    
    @Override
    public void supprimerVille(final String insee) {
        final Connection con = new JDBCConfiguration().getCo();
        try {
            (this.st = con.createStatement()).executeUpdate("DELETE FROM ville_france WHERE Code_commune_INSEE='" + insee + "';");
        }
        catch (SQLException e) {
            this.logger.error("Impossible de r\u00e9aliser la requ\u00eate.", (Throwable)e);
            try {
                this.st.close();
                con.close();
            }
            catch (SQLException e2) {
                this.logger.error("Impossible de se d\u00e9connecter.", (Throwable)e2);
            }
            return;
        }
        finally {
            try {
                this.st.close();
                con.close();
            }
            catch (SQLException e2) {
                this.logger.error("Impossible de se d\u00e9connecter.", (Throwable)e2);
            }
        }
        try {
            this.st.close();
            con.close();
        }
        catch (SQLException e2) {
            this.logger.error("Impossible de se d\u00e9connecter.", (Throwable)e2);
        }
    }
}