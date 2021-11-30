package com.dao;

import com.dto.Ville;
import java.util.ArrayList;

public interface VilleDAO
{
    ArrayList<Ville> findAllVilles();
    
    ArrayList<Ville> getVilleByInsee(final String p0);
    
    void ajouterVille(final Ville p0);
    
    void modifierVille(final Ville p0, final String p1);
    
    void supprimerVille(final String p0);
}
