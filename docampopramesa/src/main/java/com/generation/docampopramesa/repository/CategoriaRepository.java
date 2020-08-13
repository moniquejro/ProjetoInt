package br.com.generation.docampoparamesa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.docampoparamesa.model.Categoria;
import br.com.generation.docampoparamesa.model.Produto;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);

}
