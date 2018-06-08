package Projeto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import Excecoes.LoginException;

public class Usuario {
	public static List<Usuario> users = new ArrayList<Usuario>();

	private String nome;
	private String email;
	private String login;
	private String senha;
	private String pergunta;
	private String respota;

	public Usuario(String n, String e, String l, String s, String p, String r) throws LoginException {
		setNome(n);
		setEmail(e);
		setLogin(l);
		setSenha(s);
		setPergunta(p);
		setRespota(r);
		Usuario.users.add(this);

	}

	public static Usuario getUsuario(int index, String senha) throws LoginException {
		for (int i = 0; i < users.size(); i++) {
			if (i == index) {
				if (Usuario.autentica(users.get(i).getLogin(), senha)) {
					return users.get(i);
				}
			}
		}
		return null;
	}

	private static Usuario getUsuario(String login) throws LoginException {
		for (Usuario user : users) {
			if (user.getLogin().equals(login)) {
				return user;
			}
		}
		return null;
	}

	public static void updateUsuario(String login, String senha, String novo_nome, String novo_email, String novo_login,
			String nova_senha, String nova_pergunta, String nova_resposta) throws LoginException {
		if (autentica(login, senha)) {
			if (!(getUsuario(login).getNome().equals(novo_nome)) && !(novo_login.equals(""))) {
				getUsuario(login).setNome(novo_nome);
			}
			if (!(getUsuario(login).getEmail().equals(novo_email)) && !(novo_email.equals(""))) {
				getUsuario(login).setEmail(novo_email);
			}
			if (!(getUsuario(login).getSenha().equals(nova_senha)) && !(nova_senha.equals(""))) {
				getUsuario(login).setSenha(nova_senha);
			}
			if (!(getUsuario(login).getPergunta().equals(nova_pergunta)) && !(nova_pergunta.equals(""))) {
				getUsuario(login).setPergunta(nova_pergunta);
			}
			if (!(getUsuario(login).getRespota().equals(nova_resposta)) && !(nova_resposta.equals(""))) {
				getUsuario(login).setRespota(nova_resposta);
			}
			if (!(getUsuario(login).getLogin().equals(novo_login)) && !(novo_login.equals(""))) {
				getUsuario(login).setLogin(novo_login);
			}
		} else {
			throw new LoginException("Usuario n�o encontrado!");
		}
	}

	public static Usuario removeUsuario(String login, String senha) throws LoginException {
		Usuario user = Usuario.getUsuario(login);
		if (autentica(login, senha)) {
			users.remove(user);
			return user;
		}
		return null;

	}

	public static String getPergunta(String login, String email) throws LoginException {
		if (Usuario.getUsuario(login) != null) {
			if (Usuario.getUsuario(login).getEmail().equals(email)) {
				return "Sua pergunta �: " + Usuario.getUsuario(login).getPergunta();
			}
			throw new LoginException("Email n�o confere!");
		}
		throw new LoginException("Login n�o encontrado!");

	}

	public static void recuperarSenha(String login, String resposta, String nova_senha) throws LoginException {
		if (Usuario.getUsuario(login) != null) {
			if (Usuario.getUsuario(login).getRespota().equals(md5(resposta))) {
				Usuario.getUsuario(login).setSenha(nova_senha);
			} else {
				throw new LoginException("Resposta Incorreta!");
			}
		} else {
			throw new LoginException("Login n�o encontrado!");
		}
	}

	// Fun��o para criar hash da senha informada
	public static String md5(String senha) throws LoginException {
		String sen = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new LoginException(e.getMessage());
		}
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		sen = hash.toString(16);
		return sen;
	}

	public static boolean autentica(String login, String senha) throws LoginException {
		if ((Usuario.getUsuario(login) != null) && (Usuario.getUsuario(login).getLogin().equals(login))) {
			if (Usuario.getUsuario(login).getSenha().equals(md5(senha))) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return "O usuario " + this.nome + " possui o email " + this.email + " cadastrado";
	}

	public static String lista() {
		String aux = "";
		for (Usuario user : users) {
			aux += user.toString() + "\n";
		}
		return aux;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String novo_nome, String senha) throws LoginException {
		if (autentica(this.login, senha)) {
			this.setNome(novo_nome);
		} else {
			throw new LoginException("Senha Incorreta!");
		}
	}

	private void setNome(String nome) throws LoginException {
		if (nome.length() > 3) {
			this.nome = nome;
		} else {
			throw new LoginException();
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String novo_email, String senha) throws LoginException {
		if (autentica(this.login, senha)) {
			this.setEmail(novo_email);
		} else {
			throw new LoginException("Senha Incorreta!");
		}
	}

	public void setEmail(String email) throws LoginException {
		String[] desti = email.split("@");
		String[] domi = email.split("\\.");
		if (desti.length == 2) {
			if (!desti[0].equals("")) {
				if (desti[1].equals("")) {
					throw new LoginException("Email invalido!");
				}
				if (domi.length >= 2) {
					if (!domi[0].equals("")) {
						if (domi[1].equals("")) {
							throw new LoginException("Email invalido!");
						}
						this.email = email;
					} else {
						throw new LoginException("Email invalido!");
					}
				} else {
					throw new LoginException("Email invalido!");
				}

			} else {
				throw new LoginException("Email invalido!");
			}
		} else {
			throw new LoginException("Email invalido!");
		}
	}

	public String getLogin() {
		return login;
	}

	private void setLogin(String login) throws LoginException {
		if (Usuario.getUsuario(login) != null) {
			throw new LoginException("Login J� existente!");
		}
		this.login = login;
	}

	private String getSenha() {
		return senha;
	}

	private void setSenha(String senha) throws LoginException {
		this.senha = md5(senha);
	}

	private String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String nova_pergunta, String senha) throws LoginException {
		if (autentica(this.login, senha)) {
			this.setPergunta(nova_pergunta);
		} else {
			throw new LoginException("Senha Incorreta!");
		}
	}

	private void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	private String getRespota() {
		return respota;
	}

	private void setRespota(String respota) throws LoginException {
		this.respota = md5(respota);
	}
}
