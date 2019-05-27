package com.srmasset.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import srm.srmassset.dto.DetalheCEPDTO;
import srm.srmassset.dto.HealthcheckDTO;

@RestController
public class DesafioController {

	@GetMapping("/info")
	@ResponseBody
	public HealthcheckDTO info() {
		
		HealthcheckDTO healthcheck = new HealthcheckDTO("FUNCIONANDO", "Sistema está funcionando corretamente");
		
		return healthcheck;
	}

	@GetMapping("/cep/{cep}")
	@ResponseBody
	public DetalheCEPDTO getCEP(@PathVariable String cep) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		return restTemplate.getForObject("https://zuul.trusthub.com.br/orchestrator/v1/obter-endereco-por-cep/"+cep, DetalheCEPDTO.class);
		
	}
	
	@PostMapping("/cep")
	@ResponseBody
	public List<DetalheCEPDTO> getListaCEP(String ceps) {
		
		List<DetalheCEPDTO> retornoList = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();
		JSONArray jsonArray = new JSONArray(ceps);
		
		for (int i=0;i < jsonArray.length();i++) {
			
			String cep = jsonArray.getString(i);
			
			retornoList.add(restTemplate.getForObject("https://zuul.trusthub.com.br/orchestrator/v1/obter-endereco-por-cep/"+cep, DetalheCEPDTO.class));
		}
		
		
		return retornoList;
	}
	
}
