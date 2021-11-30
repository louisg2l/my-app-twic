package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {

	ArrayList<Ville> getInfoVille(final String p0);
    
    void ajouterVille(final Ville p0);
    
    void modifierVille(final Ville p0, final String p1);
    
    void supprimerVille(final String p0);

}
