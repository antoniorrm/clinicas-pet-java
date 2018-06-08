package Projeto;

import Excecoes.PetInvalidoException;

public class Pet {
	// Atributos
	private String tipo;
	private String nome;
	private String cor;
	private int dia_nascimento;
	private int mes_nascimento;
	private int ano_nascimento;

	// Construtor
	public Pet(String tipo, String nome, String cor, int dia_nascimento, int mes_nascimento, int ano_nascimento)
			throws PetInvalidoException {
		this.setTipo(tipo);
		this.setNome(nome);
		this.setCor(cor);
		this.setDia_nascimento(dia_nascimento);
		this.setMes_nascimento(mes_nascimento);
		this.setAno_nascimento(ano_nascimento);
	}

	@Override
	public String toString() {
		return "Nome: " + nome + " || Tipo: " + tipo + ", || Cor: " + cor + ", || Data de nascimento: " + dia_nascimento
				+ "/" + mes_nascimento + "/" + ano_nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws PetInvalidoException {
		if (nome.length() < 3) {
			throw new PetInvalidoException("Nome de pet inv�lido!");
		}
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) throws PetInvalidoException {
		if (cor.length() < 3) {
			throw new PetInvalidoException("Tipo inv�lido!");
		}
		this.cor = cor;
	}

	public int getDia_nascimento() {
		return dia_nascimento;
	}

	public void setDia_nascimento(int dia_nascimento) throws PetInvalidoException {
		if (dia_nascimento > 31 || dia_nascimento < 1) {
			throw new PetInvalidoException("Dia inv�lido!");
		}
		this.dia_nascimento = dia_nascimento;
	}

	public int getMes_nascimento() {
		return mes_nascimento;
	}

	public void setMes_nascimento(int mes_nascimento) throws PetInvalidoException {
		if (mes_nascimento > 12 || mes_nascimento < 1) {
			throw new PetInvalidoException("Mes inv�lido!");
		}
		this.mes_nascimento = mes_nascimento;
	}

	public int getAno_nascimento() {

		return ano_nascimento;
	}

	public void setAno_nascimento(int ano_nascimento) throws PetInvalidoException {
		if (ano_nascimento > 2016 || ano_nascimento < 1916) {
			throw new PetInvalidoException("Ano inv�lido!");
		}
		this.ano_nascimento = ano_nascimento;
	}

}
