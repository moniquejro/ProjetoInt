package com.generation.docampopramesa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.docampopramesa.model.CategoriaModel;


public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	public List<CategoriaModel> findAllBySetorContainingIgnoreCase (String setor);
	
}