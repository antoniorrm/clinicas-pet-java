package Interfaces;

import Excecoes.*;
import Projeto.*;

public interface AgendaInterface {
	public void addCliente(String nome, String email, String cpf, int dia_nascimento, int mes_nascimento,
			int ano_nascimento) throws AgendaException, ParametroInvalidoException;

	public Cliente getCliente(String nome);

	public Cliente removeCliente(int id);

	public void atualizaCliente(int id, String nome, String email) throws AgendaException;

	public void addConsulta(int idDoUsuario, Pet pet, int dia, int mes, int ano, int hora) throws AgendaException;

	public Consulta getConsulta(int dia, int mes, int ano, int hora);

	public Consulta removeConsulta(int dia, int mes, int ano, int hora) throws ConsultaException;

	public void remarcarConsulta(int diaAtual, int mesAtual, int anoAtual, int horaAtual, int dia, int mes, int ano,
			int hora) throws ConsultaException;

	public boolean verificaDisponibilidade(int dia, int mes, int ano, int hora);

	public String getAgendaDia(int dia, int mes, int ano, int k);

	public String listaClientes();

	public Cliente getCliente(int id) throws ConsultaException;
}
