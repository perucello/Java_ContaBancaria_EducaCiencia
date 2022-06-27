package educaciencia.bancaria.interfaces;

/** ************************************** 
 *  ******** EDUCACIENCIA FASTCODE *******
 *  **************************************/

import java.util.HashMap;

import educaciencia.bancaria.model.Cliente;
import educaciencia.bancaria.model.Pessoa;

public interface PermitirAcesso {

	/** metodo para fazer altenticação */
	public boolean autenticar(HashMap<Integer, Cliente> dados);

	public Pessoa acesso(Integer numero_conta, HashMap<Integer, ?> dados);

}
