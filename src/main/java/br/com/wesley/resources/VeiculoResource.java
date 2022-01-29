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
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value = "pessoa")
	public ResponseEntity<List<VeiculoDto>> findAllPessoa(@RequestParam(value = "pessoa", defaultValue = "0") Integer id_pess ) {
		List<Veiculo> list = service.findByPessoaId(id_pess);
		List<VeiculoDto> listDto = list.stream().map(obj -> new VeiculoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
		
	@GetMapping(value = "rotativo")
	public ResponseEntity<List<VeiculoDto>> findAllRotativo(@RequestParam(value = "rotativo", defaultValue = "0") Integer id_rotativo ) {
		List<Veiculo> list = service.findByRotativoId(id_rotativo);
		List<VeiculoDto> listDto = list.stream().map(obj -> new VeiculoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/estacionado")
	public ResponseEntity<List<VeiculoDto>> findByEstacionado(){
		List<Veiculo> list = service.findByEstacionado(true);
		List<VeiculoDto> listDto = list.stream().map(obj -> new VeiculoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/naoestacionado")
	public ResponseEntity<List<VeiculoDto>> findByNaoEstacionado(){
		List<Veiculo> list = service.findByEstacionado(false);
		List<VeiculoDto> listDto = list.stream().map(obj -> new VeiculoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping(value = "pessoa")
	public ResponseEntity<Veiculo> createByPessoa(@RequestParam(value = "pessoa", defaultValue = "0") Integer id_pessoa,
			@RequestBody Veiculo obj) {
		
		Veiculo newObj = service.createByPessoa(id_pessoa, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/veiculo/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value = "rotativo")
	public ResponseEntity<Veiculo> createByRotativo(@RequestParam(value = "rotativo", defaultValue = "0") Integer id_rotativo,
			@RequestBody Veiculo obj) {
		
		Veiculo newObj = service.createByRotativo(id_rotativo, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/veiculo/{id}").buildAndExpand(newObj.getId()).toUri();
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