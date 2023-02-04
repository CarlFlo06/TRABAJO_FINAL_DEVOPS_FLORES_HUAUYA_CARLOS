package com.tarea.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarea.entidad.Numeros;
import com.tarea.repositorio.NumerosRepository;

@RestController
@RequestMapping("/lista")
public class NumerosRestController {
	@Autowired
	private NumerosRepository numerosRepository;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Numeros>> listarNumeros(){
		List<Numeros> numeros = numerosRepository.findAll();
		return ResponseEntity.ok(numeros);
	}
	@PostMapping("/guardar")
	public ResponseEntity<Numeros> guardar(@RequestBody Numeros numeros){
		Numeros nuevosNumeros = numerosRepository.save(numeros);
		return ResponseEntity.ok(nuevosNumeros);
	}
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable(value="id") Long id) {
		if(id>0) {
			numerosRepository.deleteById(id);
		}
		
	}
	/*public ResponseEntity<?>listarNumeros(){
		try {
			List<Numeros>numeros=numerosRepository.findAll();
			return new ResponseEntity<List<Numeros>>(numeros,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
}
