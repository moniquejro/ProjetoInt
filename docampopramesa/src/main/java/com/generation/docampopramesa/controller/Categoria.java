package com.generation.docampopramesa.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
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

	import com.generation.docampopramesa.model.CategoriaModel;
	import com.generation.docampopramesa.repository.CategoriaRepository;

	@RestController
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping("/categoria")
	public class Categoria {
		
		@Autowired
		private CategoriaRepository repository;
		
		@GetMapping
		public ResponseEntity<List<CategoriaModel>> findAllCategoria(){
			return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping ("/{id}")
		public ResponseEntity<CategoriaModel> findByIdCategoria (@PathVariable long id){
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@PostMapping
		public ResponseEntity<CategoriaModel> postCategoria (@RequestBody CategoriaModel categoriaModel){
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(repository.save(categoriaModel));
		}
		
		@PutMapping
		public ResponseEntity<CategoriaModel> putCategoria (@RequestBody CategoriaModel categoriaModel){
			return ResponseEntity.status(HttpStatus.OK)
					.body(repository.save(categoriaModel));
		}
		
		@DeleteMapping("/{id}")
		public void deleteCategoria(@PathVariable long id) {
			repository.deleteById(id);
		}

}
