package Interfaces;

import Excecoes.ClienteException;

public interface ClienteInterface {
	public void atualizar(int id, String nome, String email) throws ClienteException;

	@Override
	public String toString();
}
