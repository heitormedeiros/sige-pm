package br.gov.rn.vandersonfabio.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
 
@Entity
@Table(name="policial")

@NamedQueries({
	@NamedQuery(name = "PolicialEntity.findAll", query="SELECT p FROM PolicialEntity p")
})
public class PolicialEntity {
 
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long codigo;
 
	@Column(name = "matricula")
	private String  matricula;
 
	@Column(name = "graduacao")
	private int graduacao;
 
	@Column(name = "nomeGuerra")
	private String nomeGuerra;
	
	@Column(name = "anoPraca")
	private int anoPraca;
	
	@Column(name = "numPraca")
	private int numPraca;
	
	@Column(name = "email")
	private String  email;
	
	@Column(name = "dataCadastro")
	private LocalDateTime	dataCadastro;
 
	@OneToOne
	@JoinColumn(name="id_usuario_cadastro")
	private UsuarioEntity usuarioEntity;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
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

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}
}