package br.com.wesley.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.wesley.domain.Rotativo;

public class RotativoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	public RotativoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RotativoDto(Rotativo obj) {
		super();
		this.id = obj.getId();
		this.dataEntrada = obj.getDataEntrada();
		this.dataSaida = obj.getDataSaida();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public LocalDateTime getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	
}
