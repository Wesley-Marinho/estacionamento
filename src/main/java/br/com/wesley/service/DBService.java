package br.com.wesley.service;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wesley.domain.Pessoa;
import br.com.wesley.domain.Rotativo;
import br.com.wesley.domain.Veiculo;
import br.com.wesley.repositories.PessoaRepository;
import br.com.wesley.repositories.RotativoRepository;
import br.com.wesley.repositories.VeiculoRepository;

@Service
public class DBService {
	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private RotativoRepository rotativoRepository;


	public void instanciaBaseDeDados() {
		
		Pessoa pessoa = new Pessoa(null, "José", "81989556271");
		
		Rotativo rotativo = new Rotativo(null, LocalDateTime.now(), LocalDateTime.now());
		
		Veiculo veiculo = new Veiculo(null, "GMHOH36", "Preto", "Fusca", false, pessoa, rotativo);
		
		pessoa.getVeiculos().addAll(Arrays.asList(veiculo));
		rotativo.getVeiculos().addAll(Arrays.asList(veiculo));
		
		rotativoRepository.saveAll(Arrays.asList(rotativo));
		pessoaRepository.saveAll(Arrays.asList(pessoa));
		veiculoRepository.saveAll(Arrays.asList(veiculo));
		
		
	}
}
