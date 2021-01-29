package com.escolaalf.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolaalf.models.Gabarito;

@RestController
@RequestMapping(value = "/gabarito")
public class GabaritoResource {
	
	public static Gabarito gabarito;
	
	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastrarGabarito(@RequestBody Gabarito gabarito){
		
		for(int i = 0; i < gabarito.getQuestoes().size(); i++) {
			if(gabarito.getQuestoes().get(i).getPeso() <= 0) {
				return ResponseEntity.badRequest().body("As questões não podem ter peso negativo");
			}
		}
		
		GabaritoResource.gabarito = gabarito;
		
		System.out.println(GabaritoResource.gabarito.toString());
		
		return ResponseEntity.ok().body("Gabarito cadastrado com sucesso");
	}

}
