package br.com.wesley.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.wesley.domain.Pessoa;

public class PessoaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message = "Campo nome requerido")
	@Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres")
	private String nome;
	
	@NotEmpty(message = "Campo telefone requerido")
	@Length(min = 8, max = 11, message = "O campo telefone deve ter entre 8 e 11 caracteres")
	private String telefone;


	public PessoaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PessoaDto(Pessoa obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.telefone = obj.getTelefone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
