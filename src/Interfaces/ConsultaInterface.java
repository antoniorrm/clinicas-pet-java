package Interfaces;

import Excecoes.*;
import Projeto.*;

public interface ConsultaInterface {
	public Consulta modificarConsulta(Cliente cli, int dia, int mes, int ano, int hora) throws ConsultaException;

	public Consulta getConsulta(int dia, int mes, int ano, int hora);

	boolean ehVoce(int dia, int mes, int ano, int hora);

	boolean ehVoce(int dia, int mes, int ano);
}
