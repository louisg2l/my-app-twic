package com.blo;

import com.dto.Ville;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.VilleDAO;
import org.springframework.stereotype.Service;

@Service
public class VilleBLOImpl implements VilleBLO
{
    @Autowired
    private VilleDAO villeDAO;
    
    @Override
    public ArrayList<Ville> getInfoVille(final String monParam) {
        ArrayList<Ville> listeVille = null;
        if (monParam == null) {
            listeVille = (ArrayList<Ville>)this.villeDAO.findAllVilles();
        }
        else {
            listeVille = (ArrayList<Ville>)this.villeDAO.getVilleByInsee(monParam);
        }
        return listeVille;
    }
    
    @Override
    public void ajouterVille(final Ville ville) {
        this.villeDAO.ajouterVille(ville);
    }
    
    @Override
    public void modifierVille(final Ville ville, final String insee) {
        this.villeDAO.modifierVille(ville, insee);
    }
    
    @Override
    public void supprimerVille(final String insee) {
        this.villeDAO.supprimerVille(insee);
    }
}
