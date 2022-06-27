package educaciencia.bancaria.model;

/** ************************************** 
 *  ******** EDUCACIENCIA FASTCODE *******
 *  **************************************/

public class Endereco {

	private String rua;
	private String cidade;
	private String estado;
	private String pais;
	private String cep;

	public Endereco() {

	}

	public Endereco(String rua, String cidade, String estado, String pais, String cep) {
		super();
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
