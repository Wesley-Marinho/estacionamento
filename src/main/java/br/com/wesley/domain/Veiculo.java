package br.com.wesley.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Veiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo placa requerido")
	@Length(min = 7, max = 7, message = "O campo placa deve 7 caracteres")
	private String placa;
	
	@NotEmpty(message = "Campo cor requerido")
	@Length(min = 4, max = 10, message = "O campo cor deve ter entre 4 e 10 caracteres")
	private String cor;
	
	@NotEmpty(message = "Campo modelo requerido")
	@Length(min = 3, max = 15, message = "O campo nome deve ter entre 3 e 15 caracteres")
	private String modelo;

	
	private Boolean estacionado;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "rotativo_id")
	private Rotativo rotativo;

	public Veiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Veiculo(Integer id, String placa, String cor, String modelo,Boolean estacionado ,Pessoa pessoa, Rotativo rotativo) {
		super();
		this.id = id;
		this.placa = placa;
		this.cor = cor;
		this.modelo = modelo;
		this.estacionado = estacionado;
		this.pessoa = pessoa;
		this.rotativo = rotativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Boolean getEstacionado() {
		return estacionado;
	}

	public void setEstacionado(Boolean estacionado) {
		this.estacionado = estacionado;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Rotativo getRotativo() {
		return rotativo;
	}

	public void setRotativo(Rotativo rotativo) {
		this.rotativo = rotativo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(id, other.id);
	}

}
