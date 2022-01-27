package br.com.wesley.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.wesley.domain.Veiculo;
import br.com.wesley.dtos.VeiculoDto;
import br.com.wesley.repositories.VeiculoRepository;
import br.com.wesley.service.exceptions.ObjectNotFoundException;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	public Veiculo findById(Integer id) {
		Optional<Veiculo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nâo encontrado! Id: " + id + "Tipo: " + Veiculo.class.getName()));
	}

	public List<Veiculo> findAll() {
		return repository.findAll();
	}

	public Veiculo create(Veiculo obj) {
		obj.setId(null);
		return repository.save(obj);
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