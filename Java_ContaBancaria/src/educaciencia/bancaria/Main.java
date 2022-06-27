package educaciencia.bancaria;

import java.util.Scanner;

import educaciencia.bancaria.controller.ControllerContaBancariaCliente;
import educaciencia.bancaria.model.Cliente;
import educaciencia.bancaria.model.ContaBancaria;

public class Main {

	static Scanner scan = new Scanner(System.in);
	public static Cliente cliente;

	static ControllerContaBancariaCliente controller = new ControllerContaBancariaCliente();

	public static void main(String[] args) {

		menu_Inicial(); // menu inicial onde o programa começa

	}// =============final main===========================

	public static void menu_Inicial() { // primeiro menu

		int op = 0, sair = 0;
		do {

			System.out.println("\t------------------------------");
			System.out.println("\t--- EDUCACIENCIA FASTCODE ----");
			System.out.println("\t 1- Criar Conta");
			System.out.println("\t 2- Login Cliente");
			System.out.println("\t 3- sair");
			System.out.println("\t------------------------------");
			op = scan.nextInt();

			if (op == 1) {

				cliente = new Cliente(new ContaBancaria());

				System.out.println("Nome :");
				cliente.setNome(scan.next());

				System.out.println("Cpf :");
				cliente.setCpf(scan.next());

				System.out.println("Email: :");
				cliente.setEmail(scan.next());

				System.out.println("Senha :");
				cliente.setSenha(scan.next());

				if (ControllerContaBancariaCliente.salvarCliente(cliente)) {

					System.out.println("Cliente Cadastrado com Sucesso !!");

				} else {

					System.err.println("ERRO ao cadastrar Cliente !! [CLIENTE JÁ EXISTE ! ]\n");
				}

			} else if (op == 2) {

				System.out.println("EMAIL :");
				String email = scan.next();

				System.out.println("SENHA :");
				String senha = scan.next();

				if (new Cliente(email, senha).autenticar(ControllerContaBancariaCliente.getClientes())) {

					cliente = new Cliente(email, senha);

					cliente = controller
							.buscarCliente(cliente); /* metodo para retornar os atributos do cliete autenticado */

					if (cliente != null) {

						System.out.println("Nome : " + cliente.getNome() + " | Numero Conta : "
								+ cliente.getContaBancaria().getNumero_conta());

						menu_Cliente(); // segundo menu dentro da conta do cliente

					} else {

						System.err.println("\t ** Perfil Admin **\n");

						System.out.println("Qual o NUMERO da conta do cliente?");
						Integer nConta = scan.nextInt();

						cliente = (Cliente) new Cliente().acesso(nConta, ControllerContaBancariaCliente.getClientes());

						if (cliente == null) {

							System.err.println("Usuario não encontrado !!\n");
						} else {
							int salir = 0;

							do {
								System.out.println("Nome : " + cliente.getNome() + " | Numero Conta : "
										+ cliente.getContaBancaria().getNumero_conta());

								System.out.println("1 - Bloquear Conta");
								System.out.println("2 - Ajustar Limite");
								System.out.println("3 - Excluir Conta ");
								System.out.println("4 - Enviar Mensagem");
								System.out.println("5 - Sair");
								int ap = scan.nextInt();

								switch (ap) {
								case 1:

									break;

								case 5:
									salir = 7;
									break;

								default:
									salir = 7;
									break;
								}

							} while (salir != 7);

						}

					}

				} else {

					System.out.println("||||  LOGIN NÃO ENCONTRADO  ||||");
				}

			} else if (op == 3) {

				sair = 3;
			}

		} while (sair != 3);
	}

	public static void menu_Cliente() { // segundo menu

		int sair = 0;

		do {
			System.out.println("\t =====================================");
			System.out.println("\t 2- Depositar");
			System.out.println("\t 3- Sacar");
			System.out.println("\t 4- Saldo");
			System.out.println("\t 5- tranferir");
			System.out.println("\t 6- Mostrar Minhas Informações");
			System.out.println("\t 7- sair");
			System.out.println("\t =====================================");
			int op = scan.nextInt();

			switch (op) {

			case 2:

				float valor = cliente.getContaBancaria().getContascliente().get(1).getSaldo();

				System.out.println("Qual o Valor do DEPOSITO?");
				cliente.getContaBancaria().getContascliente().get(1).depositar_dinheiro(scan.nextFloat());

				if (valor != cliente.getContaBancaria().getContascliente().get(1).getSaldo()) {

					System.out.println("DEPOSITO Realizado com Sucesso");

				} else {

					System.err.println("Falha ao Realizar o DEPOSITO ");

				}

				break;

			case 3:

				float valoor = cliente.getContaBancaria().getContascliente().get(1).getSaldo();

				System.out.println("Informe o Valor do SAQUE ");
				cliente.getContaBancaria().getContascliente().get(1).sacar_dinheiro(scan.nextFloat());

				if (valoor > cliente.getContaBancaria().getContascliente().get(1).getSaldo()) {

					System.out.println("SAQUE realizado com sucesso");

				} else {

					System.err.println("Erro ao SACAR");

				}

				break;

			case 4:

				System.out.println(" SALDO : " + cliente.getContaBancaria().getContascliente().get(1).getSaldo());

				break;

			case 5:

				float saldoo = cliente.getContaBancaria().getContascliente().get(1).getSaldo();

				System.out.println("Qual o VALOR para TRANFERIR");
				float vallor = scan.nextFloat();

				System.out.println("Informe a CHAVE do PIX ");
				int pix = scan.nextInt();

				cliente.getContaBancaria().getContascliente().get(1).transferir_dinheiro(vallor, pix);

				if (saldoo > cliente.getContaBancaria().getContascliente().get(1).getSaldo()) {

					System.out.println("TRANSFERENCIA realizada com Sucesso !!");

				} else {

					System.err.println("Erro ao FAZER TRANSFERENCIA");

				}

				break;

			case 6:

				System.out.println("\n XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \n");
				System.out.println("\t NOME: " + cliente.getNome());
				System.out.println("\t EMAIL:" + cliente.getEmail());
				System.out.println("\t NUMERO CONTA :" + cliente.getContaBancaria().getNumero_conta());
				System.out.println("\n XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \n");

				break;

			default:

				sair = 7;

				break;

			}

		} while (sair != 7);

	}// ----

}