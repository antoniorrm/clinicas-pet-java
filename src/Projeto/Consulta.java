package Projeto;

import Excecoes.ConsultaException;
import Interfaces.ConsultaInterface;

public class Consulta implements ConsultaInterface {
	private int dia;
	private int mes;
	private int ano;
	private int hora;
	private Cliente my;
	private Pet mypet;

	public Consulta(Cliente cliente, Pet pet, int dia, int mes, int ano, int hora) throws ConsultaException {
		setDia(dia);
		setMes(mes);
		setAno(ano);
		setHora(hora);
		setMy(cliente);
		setMypet(pet);

	}

	@Override
	public Consulta modificarConsulta(Cliente cli, int dia, int mes, int ano, int hora) throws ConsultaException {
		this.setMy(cli);
		this.setDia(dia);
		this.setMes(mes);
		this.setAno(ano);
		this.setHora(hora);
		return this;
	}

	@Override
	public Consulta getConsulta(int dia, int mes, int ano, int hora) {
		return this;
	}

	@Override
	public boolean ehVoce(int dia, int mes, int ano, int hora) {
		if (this.getDia() == dia && this.getMes() == mes && this.getAno() == ano && getHora() == hora) {
			return true;
		}
		return false;
	}

	@Override
	public boolean ehVoce(int dia, int mes, int ano) {
		if (this.getDia() == dia && this.getMes() == mes && this.getAno() == ano) {
			return true;
		}
		return false;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) throws ConsultaException {
		if (dia < 1 || dia > 31) {
			throw new ConsultaException("Dia invalido!");
		}
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) throws ConsultaException {
		if (mes < 1 || mes > 12) {
			throw new ConsultaException("Mes invalido!");
		}
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) throws ConsultaException {
		if (ano < 0) {
			throw new ConsultaException("Dia invalido!");
		}
		this.ano = ano;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) throws ConsultaException {
		if (hora < 1 || hora > 23) {
			throw new ConsultaException("Hora Invalida!");
		}
		this.hora = hora;
	}

	public Cliente getMy() {
		return my;
	}

	public void setMy(Cliente cliente) {
		this.my = cliente;
	}

	public Pet getMypet() {
		return mypet;
	}

	public void setMypet(Pet mypet) {
		this.mypet = mypet;
	}
}
