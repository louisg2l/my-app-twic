package com.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dto.Ville;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.blo.VilleBLO;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VilleController
{
    @Autowired
    VilleBLO villeBLOService;
    
    @RequestMapping(value = { "/ville" }, method = { RequestMethod.GET })
    @ResponseBody
    public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "codeInsee") final String insee) {
        System.out.println("Appel GET");
        return this.villeBLOService.getInfoVille(insee);
    }
    
    @RequestMapping(value = { "/ville" }, method = { RequestMethod.POST })
    public void appelPost(@RequestBody final Ville newVille) {
        System.out.println("Appel POST");
        this.villeBLOService.ajouterVille(newVille);
    }
    
    @RequestMapping(value = { "/ville" }, method = { RequestMethod.PUT })
    public void appelPut(@RequestBody final Ville newVille, @RequestParam(required = true, value = "insee") final String insee) {
        System.out.println("Appel PUT");
        this.villeBLOService.modifierVille(newVille, insee);
    }
    
    @RequestMapping(value = { "/ville" }, method = { RequestMethod.DELETE })
    public void appelDelete(@RequestParam(required = true, value = "insee") final String insee) {
        System.out.println("Appel DELETE");
        this.villeBLOService.supprimerVille(insee);
    }
}
