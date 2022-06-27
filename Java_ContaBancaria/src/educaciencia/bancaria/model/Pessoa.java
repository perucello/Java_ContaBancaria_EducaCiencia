package educaciencia.bancaria.model;

/** ************************************** 
 *  ******** EDUCACIENCIA FASTCODE *******
 *  **************************************/

public abstract class Pessoa {

	protected String nome;
	protected String cpf;
	protected String rg;
	protected int diaNascimneto, mesNascimneto, anoNascimneto;
	protected int idade;
	protected String telefone;
	protected String email;
	protected String senha;
	protected Endereco endereco;

	public Pessoa() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public int getDiaNascimneto() {
		return diaNascimneto;
	}

	public void setDiaNascimneto(int diaNascimneto) {
		this.diaNascimneto = diaNascimneto;
	}

	public int getMesNascimneto() {
		return mesNascimneto;
	}

	public void setMesNascimneto(int mesNascimneto) {
		this.mesNascimneto = mesNascimneto;
	}

	public int getAnoNascimneto() {
		return anoNascimneto;
	}

	public void setAnoNascimneto(int anoNascimneto) {
		this.anoNascimneto = anoNascimneto;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", email=" + email + "]";
	}

}
