package com.escolaalf.models;

public class Questao {
	
	private String alternativa;
	private int peso;
	
	
	public String getAlternativa() {
		return alternativa;
	}
	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return "Questao [alternativa=" + alternativa + ", peso=" + peso + "]";
	}

}
