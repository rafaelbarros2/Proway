package com.escolaalf.models;

import java.util.ArrayList;
import java.util.List;

public class Gabarito {
	
	private List<Questao> questoes = new ArrayList<>();
	
	public Gabarito() {
		super();
	}

	public Gabarito(List<Questao> questoes) {
		super();
		this.questoes = questoes;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	@Override
	public String toString() {
		return "Gabarito [questoes=" + questoes + "]";
	}

}
