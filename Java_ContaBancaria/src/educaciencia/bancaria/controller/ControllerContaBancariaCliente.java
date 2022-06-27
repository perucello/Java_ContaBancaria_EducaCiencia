package educaciencia.bancaria.controller;

/** ************************************** 
 *  ******** EDUCACIENCIA FASTCODE *******
 *  **************************************/

import java.util.HashMap;

import educaciencia.bancaria.model.Cliente;
import educaciencia.bancaria.model.Debito;
import educaciencia.bancaria.model.Poupanca;

public class ControllerContaBancariaCliente {

	private static HashMap<Integer, Cliente> MapsDeClientes = null;

	private static Integer num = 100; // numero inicial das contas bancarias

	public ControllerContaBancariaCliente() {

		if (MapsDeClientes == null) {

			MapsDeClientes = new HashMap<Integer, Cliente>();
		}
	}

	/** gets */
	public static HashMap<Integer, Cliente> getClientes() {

		return MapsDeClientes;
	}

	/* gera um numero de conta para o cliente */
	public static Integer numeroConta() {

		String ccNumber = "200";

		int sum = num + MapsDeClientes.size();
		boolean alternate = false;
		for (int i = ccNumber.length() - 1; i >= 0; i--) {
			int n = Integer.parseInt(ccNumber.substring(i, i + 1));
			if (alternate) {
				n *= 2;
				if (n > 9) {
					n = (n % 10) + 1;
				}
			}
			sum += n;
			alternate = !alternate;
		}

		return sum;
	}

	/** salva o cliente no MAP */
	public static boolean salvarCliente(Cliente cliente) {
		boolean resposta = false;
		if (autenticar(cliente)) {

			Integer numeroCONTAgerado = numeroConta();

			cliente.getContaBancaria().getContascliente().add(new Debito());
			cliente.getContaBancaria().getContascliente().add(new Poupanca());
			cliente.getContaBancaria().setNumero_conta(numeroCONTAgerado);

			MapsDeClientes.put(numeroCONTAgerado, cliente);/* salva o cliente na map */

			for (Integer i : MapsDeClientes.keySet()) {

				System.out.println(MapsDeClientes.get(i));
			}

			resposta = true;

		}

		return resposta;
	}

	/** verifica se existe ja esiste e numero da conta bancaria */
	protected static boolean VerificarConta(Cliente cliente) {

		boolean resposta = true;

		/** metodo para checar se existe a chave */
		if (MapsDeClientes.containsKey(cliente.getContaBancaria().getNumero_conta())) {

			resposta = false;
		}

		return resposta;
	}

	/** verifica se o cliente ja existe */
	public static boolean autenticar(Cliente cliente) { // autenticar o cliente no login
		boolean verifica = true;

		// MapsDeClientes.get(cliente.getContaBancaria().getNumero_conta());

		verifica = VerificarConta(cliente);

		/** percorre as key map */
		for (Integer i : MapsDeClientes.keySet()) {

			if (MapsDeClientes.get(i).getEmail().equals(cliente.getEmail())
					&& MapsDeClientes.get(i).getSenha().equals(cliente.getSenha())) {

				verifica = false;
				break;
			}

		}

		return verifica;
	}

	public Cliente buscarCliente(Cliente cliente) {

		Integer numero_conta = 0000;

		for (Integer i : MapsDeClientes.keySet()) {

			if (MapsDeClientes.get(i).getEmail().equals(cliente.getEmail())
					&& MapsDeClientes.get(i).getSenha().equals(cliente.getSenha())) {

				numero_conta = MapsDeClientes.get(i).getContaBancaria().getNumero_conta();

				break;
			}

		}

		return (cliente = (Cliente) new Cliente().acesso(numero_conta, MapsDeClientes));

	}

}
