package br.gov.rn.vandersonfabio.model;

import java.time.LocalDateTime;

public class PolicialModel {
	
	private long id;
	private String matricula;
	private int graduacao;
	private String nomeGuerra;
	private int anoPraca;
	private int numPraca;
	private String email;
	private LocalDateTime dataCadastro;
	private UsuarioModel usuarioModel;
	
	private String graduacaoEmTexto;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getGraduacao() {
		return graduacao;
	}
	public void setGraduacao(int graduacao) {
		this.graduacao = graduacao;
	}
	public String getNomeGuerra() {
		return nomeGuerra;
	}
	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}
	public int getAnoPraca() {
		return anoPraca;
	}
	public void setAnoPraca(int anoPraca) {
		this.anoPraca = anoPraca;
	}
	public int getNumPraca() {
		return numPraca;
	}
	public void setNumPraca(int numPraca) {
		this.numPraca = numPraca;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
	
	public String getGraduacaoEmTexto() {
		switch (this.graduacao) {
		case(0):
			return "Soldado";
		case(1):
			return "Cabo";
		case(2):
			return "1º Sargento";
		case(3):
			return "2º Sargento";
		case(4):
			return "3º Sargento";
		case(5):
			return "Sub-Tenente";
		case(6):
			return "2º Tenente";
		case(7):
			return "1º Tenente";
		case(8):
			return "Capitão";
		case(9):
			return "Major";
		case(10):
			return "Tenente-Coronel";
		case(11):
			return "Coronel";
		default:
			return "Graduação inválida";
		}		
	}
	
	public void setGraduacaoEmTexto(String valor) {
		this.graduacaoEmTexto = valor;
	}
}
