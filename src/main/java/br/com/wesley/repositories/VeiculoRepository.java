package br.com.wesley.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.wesley.domain.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
	
	@Query("SELECT obj FROM Veiculo obj WHERE obj.pessoa.id = :id_pessoa")
	List<Veiculo> findByPessoaId(Integer id_pessoa);
	
	@Query("SELECT obj FROM Veiculo obj WHERE obj.rotativo.id = :id_rotativo")
	List<Veiculo> findByRotativoId(Integer id_rotativo);
	
	List<Veiculo> findByEstacionado(Boolean estacionado);
	
	
	
}
