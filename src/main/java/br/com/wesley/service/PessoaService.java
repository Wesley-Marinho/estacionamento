package br.com.wesley.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.wesley.domain.Pessoa;
import br.com.wesley.dtos.PessoaDto;
import br.com.wesley.repositories.PessoaRepository;
import br.com.wesley.service.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public Pessoa findById(Integer id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nâo encontrado! Id: " + id + "Tipo: " + PessoaService.class.getName()));

	}

	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	public Pessoa create(Pessoa obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Pessoa update(Integer id, PessoaDto objDto) {
		Pessoa obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setTelefone(objDto.getTelefone());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new br.com.wesley.service.exceptions.DataIntegrityViolationException(
					"Objeto não pode ser deletado, possui carros vinculados.");
		}

	}

}
