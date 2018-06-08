package Projeto;

import java.util.ArrayList;
import java.util.List;

import Excecoes.ClienteException;
import Excecoes.ParametroInvalidoException;
import Excecoes.PetInvalidoException;

public class Pessoa {
	// Atributos
	private String nome;
	private String cpf;
	private int dia_nascimento;
	protected int mes_nascimento;
	private int ano_nascimento;
	public List<Pet> pets;

	// Construtor
	public Pessoa(String nome, String cpf, int dia_nascimento, int mes_nascimento, int ano_nascimento)
			throws ParametroInvalidoException, ClienteException {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setDia_nascimento(dia_nascimento);
		this.setMes_nascimento(mes_nascimento);
		this.setAno_nascimento(ano_nascimento);
		pets = new ArrayList<Pet>();
	}

	// Metodo para adicionar Pet na lista pets
	public void add_pet(String tipo, String nome, String cor, int dia_nascimento, int mes_nascimento,
			int ano_nascimento) throws PetInvalidoException {
		pets.add(new Pet(tipo, nome, cor, dia_nascimento, mes_nascimento, ano_nascimento));
	}

	// Metodo para remover Pet da lista pets
	public void remove_pet(String tipo, String nome) {
		for (int i = 0; i < pets.size(); i++) {
			if (pets.get(i).getTipo().equals(tipo) && pets.get(i).getNome().equals(nome)) {
				pets.remove(pets.get(i));
			}
		}
	}

	// Metodo para buscar Pet da lista pets
	public Pet buscar_pet(String nome) throws PetInvalidoException {
		for (Pet pet : pets) {
			if (pet.getNome().equals(nome)) {
				return pet;
			}
		}
		throw new PetInvalidoException("Pet n�o cadastrado!");
	}

	// Metodo para listar os Pet da lista pets
	public String listar_pets() {
		String aux = "";
		for (Pet pet : pets) {
			aux += pet.toString() + "\n";
		}
		if (aux.equals("")) {
			return "Pets n�o cadastrados!";
		}
		return aux;
	}

	@Override
	public String toString() {
		return " Nome = " + nome + ",\n Cpf = " + cpf + ",\n Dia de nascimento = " + dia_nascimento
				+ ",\n Mes de nascimento = " + mes_nascimento + ",\n Ano de nascimento = " + ano_nascimento
				+ ",\n Pets = " + listar_pets();

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ParametroInvalidoException {
		if (nome.length() < 3) {
			throw new ParametroInvalidoException("Nome inv�lido!");
		}

		this.nome = nome;
	}

	public String getCpf() {

		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getDia_nascimento() {
		return dia_nascimento;
	}

	public void setDia_nascimento(int dia_nascimento) throws ParametroInvalidoException {
		if (dia_nascimento > 31 || dia_nascimento < 1) {
			throw new ParametroInvalidoException("Dia inv�lido!");
		}
		this.dia_nascimento = dia_nascimento;
	}

	public int getMes_nascimento() {
		return mes_nascimento;
	}

	public void setMes_nascimento(int mes_nascimento) throws ParametroInvalidoException {
		if (mes_nascimento > 12 || mes_nascimento < 1) {
			throw new ParametroInvalidoException("Mes inv�lido!");
		}
		this.mes_nascimento = mes_nascimento;
	}

	public int getAno_nascimento() {

		return ano_nascimento;
	}

	public void setAno_nascimento(int ano_nascimento) throws ParametroInvalidoException {
		if (ano_nascimento > 2016 || ano_nascimento < 1817) {
			throw new ParametroInvalidoException("Ano inv�lido!");
		}
		this.ano_nascimento = ano_nascimento;
	}

}
