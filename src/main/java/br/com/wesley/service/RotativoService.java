package br.com.wesley.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.wesley.domain.Rotativo;
import br.com.wesley.dtos.RotativoDto;
import br.com.wesley.repositories.RotativoRepository;
import br.com.wesley.service.exceptions.ObjectNotFoundException;

@Service
public class RotativoService {

	@Autowired
	private RotativoRepository repository;

	public Rotativo findById(Integer id) {
		Optional<Rotativo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nâo encontrado! Id: " + id + "Tipo: " + Rotativo.class.getName()));
	}

	public List<Rotativo> findAll() {
		return repository.findAll();
	}

	public Rotativo create(Rotativo obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Rotativo update(Integer id, RotativoDto objDto) {
		Rotativo obj = findById(id);
		obj.setDataEntrada(objDto.getDataEntrada());
		obj.setDataSaida(objDto.getDataSaida());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new br.com.wesley.service.exceptions.DataIntegrityViolationException(
					"Objeto não pode ser deletado, possui carros associados.");
		}

	}
}
