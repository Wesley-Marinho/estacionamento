package br.com.wesley.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import br.com.wesley.domain.Rotativo;
import br.com.wesley.dtos.RotativoDto;
import br.com.wesley.service.RotativoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/rotativos")
public class RotativoResource {

	@Autowired
	private RotativoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Rotativo> findById(@PathVariable Integer id) {
		Rotativo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<RotativoDto>> findAll() {
		List<Rotativo> list = service.findAll();
		List<RotativoDto> listDto = list.stream().map(obj -> new RotativoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}

	@PostMapping
	public ResponseEntity<Rotativo> create(@RequestBody Rotativo obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<RotativoDto> update(@PathVariable Integer id, @RequestBody RotativoDto objDto) {
		Rotativo newObj = service.update(id, objDto);
		return ResponseEntity.ok().body(new RotativoDto(newObj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}