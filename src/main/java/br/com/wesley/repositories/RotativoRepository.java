package br.com.wesley.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wesley.domain.Rotativo;

@Repository
public interface RotativoRepository extends JpaRepository<Rotativo, Integer>{

}
