package br.com.wesley.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.wesley.domain.Veiculo;

public class VeiculoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Campo placa requerido")
	@Length(min = 7, max = 7, message = "O campo placa deve 7 caracteres")
	private String placa;
	
	@NotEmpty(message = "Campo cor requerido")
	@Length(min = 4, max = 10, message = "O campo cor deve ter entre 4 e 10 caracteres")
	private String cor;
	
	@NotEmpty(message = "Campo modelo requerido")
	@Length(min = 5, max = 15, message = "O campo nome deve ter entre 5 e 15 caracteres")
	private String modelo;
	
	
	private Boolean estacionado;

	public VeiculoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VeiculoDto(Veiculo obj) {
		super();
		this.id = obj.getId();
		this.placa = obj.getPlaca();
		this.cor = obj.getCor();
		this.modelo = obj.getModelo();
		this.estacionado = obj.getEstacionado();
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
}
