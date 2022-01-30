package br.com.wesley.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.wesley.domain.Pessoa;
import br.com.wesley.domain.Rotativo;
import br.com.wesley.domain.Veiculo;
import br.com.wesley.dtos.VeiculoDto;
import br.com.wesley.repositories.VeiculoRepository;
import br.com.wesley.service.exceptions.ObjectNotFoundException;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private RotativoService rotativoService;
	
	public Veiculo findById(Integer id) {
		Optional<Veiculo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nâo encontrado! Id: " + id + "Tipo: " + Veiculo.class.getName()));
	}

	public List<Veiculo> findAll() {
		return repository.findAll();
	}
	
	public List<Veiculo> findByEstacionado(Boolean estacionamento){
		return repository.findByEstacionado(estacionamento);
	}
	
	public List<Veiculo> findByPessoaId(Integer id){
		pessoaService.findById(id);
		return repository.findByPessoaId(id);		
	}
	
	public List<Veiculo> findByRotativoId(Integer id){
		rotativoService.findById(id);
		return repository.findByRotativoId(id);		
	}
	
	public Veiculo createByPessoa(Integer id_pessoa,Veiculo obj) {
		obj.setId(null);
		Pessoa pessoa = pessoaService.findById(id_pessoa);
		obj.setPessoa(pessoa);
		return repository.save(obj);
	}

	public Veiculo updateByRotativo(Integer id , Veiculo obj) {
		Rotativo rotativo = rotativoService.findById(id);
		Veiculo veiculo = findById(obj.getId());
		veiculo.setRotativo(rotativo);
		veiculo.setEstacionado(obj.getEstacionado());
		return repository.save(veiculo);
	}
	
	public Veiculo update(Integer id, VeiculoDto objDto) {
		Veiculo obj = findById(id);
		obj.setCor(objDto.getCor());
		obj.setModelo(objDto.getModelo());
		obj.setPlaca(objDto.getPlaca());
		obj.setEstacionado(objDto.getEstacionado());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new br.com.wesley.service.exceptions.DataIntegrityViolationException(
					"Objeto não pode ser deletado, possui pessoas associados ou rotativos vinculados.");
		}

	}
}