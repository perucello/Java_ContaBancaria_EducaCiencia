package educaciencia.bancaria.model;

/** ************************************** 
 *  ******** EDUCACIENCIA FASTCODE *******
 *  **************************************/

import java.util.HashMap;

import educaciencia.bancaria.interfaces.PermitirAcesso;

public class Cliente extends Pessoa implements PermitirAcesso {

	private ContaBancaria contaBancaria;

	public Cliente() {

	}

	public Cliente(String email, String senha) {

		this.email = email;
		this.senha = senha;

	}

	public Cliente(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	@Override
	public boolean autenticar(HashMap<Integer, Cliente> dados) {

		for (Integer i : dados.keySet()) {

			if (dados.get(i).getEmail().equals(this.email) && dados.get(i).getSenha().equals(this.senha)) {

				return true;
			}

		}

		return this.email.equals("admin") && this.senha.equals("admin");
	}

	@Override
	public String toString() {
		return "Cliente [contaBancaria=" + contaBancaria + "]";
	}

	@Override
	public Pessoa acesso(Integer numero_conta, HashMap<Integer, ?> dados) {

		if (dados.containsKey(numero_conta)) {

			return (Cliente) dados.get(numero_conta);

		}

		return null;
	}

}
