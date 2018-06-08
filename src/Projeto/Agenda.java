package Projeto;

import java.util.ArrayList;
import java.util.List;

import Excecoes.*;
import Interfaces.AgendaInterface;

public class Agenda implements AgendaInterface {
	public static List<Consulta> consultas = new ArrayList<Consulta>();
	public static List<Cliente> clientes = new ArrayList<Cliente>();

	@Override
	public void addCliente(String nome, String email, String cpf, int dia_nascimento, int mes_nascimento,
			int ano_nascimento) throws AgendaException {
		try {
			if (getCliente(nome) != null) {
				throw new AgendaException("Login J� existente!");
			}
			clientes.add(new Cliente(nome, email, cpf, dia_nascimento, mes_nascimento, ano_nascimento));
		} catch (ClienteException e) {
			throw new AgendaException(e.getMessage());
		} catch (ParametroInvalidoException e) {
			throw new AgendaException(e.getMessage());
		}
	}

	@Override
	public Cliente getCliente(String nome) {
		for (Cliente cliente : clientes) {
			if (cliente.getNome().equals(nome)) {
				return cliente;
			}
		}
		return null;
	}

	@Override
	public Cliente removeCliente(int id) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getId() == id) {
				clientes.remove(i);
			}
		}
		return null;
	}

	@Override
	public void atualizaCliente(int id, String nome, String email) throws AgendaException {
		for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				try {
					cliente.atualizar(id, nome, email);
				} catch (ClienteException e) {
					throw new AgendaException(e.getMessage());
				}
			}
		}

	}

	@Override
	public void addConsulta(int idDoUsuario, Pet pet, int dia, int mes, int ano, int hora) throws AgendaException {
		try {
			if (verificaDisponibilidade(dia, mes, ano, hora)) {
				consultas.add(new Consulta(getCliente(idDoUsuario), pet, dia, mes, ano, hora));
			} else {
				throw new AgendaException("Dia ou hora j� marcada!");
			}
		} catch (ConsultaException e) {
			throw new AgendaException(e.getMessage());
		}

	}

	@Override
	public Consulta getConsulta(int dia, int mes, int ano, int hora) {
		for (Consulta c : consultas) {
			if (c.ehVoce(dia, mes, ano, hora)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public Consulta removeConsulta(int dia, int mes, int ano, int hora) throws ConsultaException {

		if (verificaDisponibilidade(dia, mes, ano, hora)) {
			throw new ConsultaException("N�o h� Consulta marcada!");
		} else {
			Consulta aux = getConsulta(dia, mes, ano, hora);
			consultas.remove(aux);
			return aux;
		}

	}

	@Override
	public void remarcarConsulta(int diaAtual, int mesAtual, int anoAtual, int horaAtual, int dia, int mes, int ano,
			int hora) throws ConsultaException {
		Consulta aux;
		if (verificaDisponibilidade(diaAtual, mesAtual, anoAtual, horaAtual) == false) {
			if (verificaDisponibilidade(dia, mes, ano, hora)) {
				aux = getConsulta(diaAtual, mesAtual, anoAtual, horaAtual);
				aux.modificarConsulta(aux.getMy(), dia, mes, ano, hora);
			} else {
				throw new ConsultaException("Data ou hor�rio j� marcado!");
			}
		} else {
			throw new ConsultaException("Consulta n�o encontrada!");
		}
	}

	@Override
	public boolean verificaDisponibilidade(int dia, int mes, int ano, int hora) {
		if (getConsulta(dia, mes, ano, hora) == null) {
			return true;
		}
		return false;
	}

	@Override
	public String getAgendaDia(int dia, int mes, int ano, int k) {
		for (int i = 0; i < consultas.size(); i++) {
			if (consultas.get(i).ehVoce(dia, mes, ano, k) == true) {
				return "Pet: " + getConsulta(dia, mes, ano, k).getMypet().getNome() + "\n do Cliente: "
						+ getConsulta(dia, mes, ano, k).getMy().getNome() + " �s "
						+ getConsulta(dia, mes, ano, k).getHora() + " horas";
			}
		}
		return null;
	}

	@Override
	public String listaClientes() {
		String aux = "";
		for (Cliente cliente : clientes) {
			aux += cliente.toString();
		}
		return aux;
	}

	@Override
	public Cliente getCliente(int id) throws ConsultaException {
		for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				return cliente;
			}
		}
		throw new ConsultaException("Cliente n�o encontrado!");

	}

	public Cliente getClienteI(int index) throws ConsultaException {
		for (int i = 0; i < clientes.size(); i++) {
			if (i == index) {
				return clientes.get(i);
			}
		}
		throw new ConsultaException("Cliente n�o encontrado!");

	}

}
