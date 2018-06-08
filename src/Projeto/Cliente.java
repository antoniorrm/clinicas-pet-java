package Projeto;

import Excecoes.ClienteException;
import Excecoes.ParametroInvalidoException;
import Interfaces.ClienteInterface;

public class Cliente extends Pessoa implements ClienteInterface {
	private static int idG = 0;
	private int id;
	private String email;

	public Cliente(String nome, String email, String cpf, int dia_nascimento, int mes_nascimento, int ano_nascimento)
			throws ClienteException, ParametroInvalidoException {

		super(nome, cpf, dia_nascimento, mes_nascimento, ano_nascimento);
		setId(idG);
		setEmail(email);
		idG++;
	}

	@Override
	public void atualizar(int id, String nome, String email) throws ClienteException {
		try {
			super.setNome(nome);
		} catch (ParametroInvalidoException e) {
			throw new ClienteException(e.getMessage());
		}
		setEmail(email);

	}

	@Override
	public String toString() {
		return getId() + "-" + getNome() + " email: " + getEmail() + "\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	/**
	 *
	 * Seta o menun
	 **/
	public void setEmail(String email) throws ClienteException {
		String[] desti = email.split("@");
		String[] domi = email.split("\\.");
		if (desti.length == 2) {
			if (!desti[0].equals("")) {
				if (desti[1].equals("")) {
					throw new ClienteException("Email invalido!");
				}
				if (domi.length >= 2) {
					if (!domi[0].equals("")) {
						if (domi[1].equals("")) {
							throw new ClienteException("Email invalido!");
						}
						this.email = email;
					} else {
						throw new ClienteException("Email invalido!");
					}
				} else {
					throw new ClienteException("Email invalido!");
				}

			} else {
				throw new ClienteException("Email invalido!");
			}
		} else {
			throw new ClienteException("Email invalido!");
		}
	}

}
