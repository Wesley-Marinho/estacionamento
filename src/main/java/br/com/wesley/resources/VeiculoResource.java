package br.com.wesley.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.wesley.domain.Veiculo;
import br.com.wesley.dtos.VeiculoDto;
import br.com.wesley.service.VeiculoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {

	@Autowired
	private VeiculoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Veiculo> findById(@PathVariable Integer id) {
		Veiculo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<VeiculoDto>> findAll() {
		List<Veiculo> list = service.findAll();
		List<VeiculoDto> listDto = list.stream().map(obj -> new VeiculoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}

	@PostMapping
	public ResponseEntity<Veiculo> create(@Valid @RequestBody Veiculo obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<VeiculoDto> update(@Valid @PathVariable Integer id, @RequestBody VeiculoDto objDto) {
		Veiculo newObj = service.update(id, objDto);
		return ResponseEntity.ok().body(new VeiculoDto(newObj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}