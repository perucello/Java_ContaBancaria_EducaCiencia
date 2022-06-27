package educaciencia.bancaria.model;

/** ************************************** 
 *  ******** EDUCACIENCIA FASTCODE *******
 *  **************************************/

import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {

	private Integer numero_conta;

	private List<Conta> contascliente = new ArrayList<Conta>();

	public Integer getNumero_conta() {
		return numero_conta;
	}

	public void setNumero_conta(Integer numero_conta) {
		this.numero_conta = numero_conta;
	}

	public List<Conta> getContascliente() {
		return contascliente;
	}

	public void setContascliente(List<Conta> contascliente) {
		this.contascliente = contascliente;
	}

	public float transferir_dinheiro(float valor) {

		return valor;
	}

	@Override
	public String toString() {
		return "ContaBancaria [numero_conta=" + numero_conta + "]";
	}

}

/**
 * Elabore uma classe ContaBancaria, com os seguintes atributos e métodos:
 * atributo String cliente atributo int num_conta atributo float saldo sacar (o
 * saldo não pode ficar negativo) método depositar
 */