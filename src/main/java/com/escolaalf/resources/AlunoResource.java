package com.escolaalf.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.escolaalf.models.Aluno;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

	private List<Aluno> alunos;
	private double valorProva = 0;
	private double respostasCorretas = 0;
	private double notaFinal = 0;
	private List<String> aprovados = new ArrayList<>();
	
	ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "/prova-aluno", method = RequestMethod.POST)
	public ResponseEntity<?> cadastrarProvaAluno(@RequestBody List<Aluno> listaDeAlunos) {

		if (listaDeAlunos.size() <= 0) {
			return ResponseEntity.badRequest().body("Lista vazia");
		} else if (listaDeAlunos.size() > 100) {
			return ResponseEntity.badRequest()
					.body("Quantidade de listaDeAlunoss excedida! (permitida: 100 cadastrada: " + listaDeAlunos.size());
		}

		this.alunos = listaDeAlunos;

		return ResponseEntity.ok("Provas cadastrada com sucesso");
	}

	@RequestMapping(value = "/provas-notas-alunos", method = RequestMethod.GET)
	public ResponseEntity<?> verificarNotaAluno() {

		System.out.println(GabaritoResource.gabarito.getQuestoes().size());
		
		for (int j = 0; j < alunos.size(); j++) {
			if (GabaritoResource.gabarito.getQuestoes().size() > 0
					&& GabaritoResource.gabarito.getQuestoes().size() == this.alunos.get(j).getProvas().size()) {
				for (int i = 0; i < GabaritoResource.gabarito.getQuestoes().size(); i++) {
					if (this.alunos.get(j).getProvas().get(i).equals(GabaritoResource.gabarito.getQuestoes().get(i).getAlternativa())) {
						this.respostasCorretas += GabaritoResource.gabarito.getQuestoes().get(i).getPeso();
					}
					this.valorProva += GabaritoResource.gabarito.getQuestoes().get(i).getPeso();
				}
				this.notaFinal = (this.respostasCorretas / this.valorProva) * 10;
			} else {
				return ResponseEntity.badRequest().body("gabarito vazio ou prova incompleta");
			}

			alunos.get(j).setNota((int) this.notaFinal);
			if (notaFinal >= 7) {
				aprovados.add(this.alunos.get(j).getNomeDoAluno());
			}
		}
		return ResponseEntity
				.ok().body(Arrays.asList(aprovados));
	}
	
	@RequestMapping(value = "/provas-nota-final", method = RequestMethod.GET)
	public ResponseEntity<?> verificarNotaFinal() {
		
		try {
			if(this.alunos.size() > 0) {
				String resultado = mapper.writeValueAsString(this.alunos);
				return ResponseEntity.ok(resultado);
			}
			return ResponseEntity.ok().body("Lista vazia");
		} catch (JsonProcessingException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}

}
