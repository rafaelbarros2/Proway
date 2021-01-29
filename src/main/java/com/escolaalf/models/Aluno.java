package com.escolaalf.models;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
	private String nomeDoAluno;
	private List<String> provas = new ArrayList<>();
	private int nota;
	
	public Aluno(String nomeDoAluno, List<String> provas) {
		super();
		this.nomeDoAluno = nomeDoAluno;
		this.provas = provas;
	}

	public String getNomeDoAluno() {
		return nomeDoAluno;
	}

	public void setNomeDoAluno(String nomeDoAluno) {
		this.nomeDoAluno = nomeDoAluno;
	}

	public List<String> getProvas() {
		return provas;
	}

	public void setProvaDoAluno(List<String> provas) {
		this.provas = provas;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Aluno [nomeDoAluno=" + nomeDoAluno + ", provas=" + provas + ", nota=" + nota + "]";
	}



}
