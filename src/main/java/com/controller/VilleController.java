package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blo.VilleBLO;
import com.dto.Ville;

public class VilleController {

	VilleBLO villeService;
	
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public Ville appelGet(@RequestParam(required = false, value = "codePostal") String codePostal) {
		System.out.println("codePostal : " + codePostal);
	
		return villeService.getInfoVilles();
	}
}