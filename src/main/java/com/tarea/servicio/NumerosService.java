package com.tarea.servicio;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.tarea.entidad.Numeros;
import com.tarea.modelo.Suma;
import com.tarea.repositorio.NumerosRepository;

@Service
public class NumerosService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private NumerosRepository numerosRepository;
	
	public List<Suma> getAll(){
		List<Suma> n=Arrays.asList(restTemplate.getForObject("http://localhost:9595/lista/listar",Suma[].class));
		return n;
	}
	
	public Numeros  saveAll(@RequestBody Numeros suma){
		Numeros nuevosNumeros = numerosRepository.save(suma);
		return nuevosNumeros;
	}
	
	public Numeros getNumerosById(Long id) {
		return numerosRepository.findById(id).orElse(null);
	}
	public void delete(Long id) {
		numerosRepository.deleteById(id);
	}
	/*public Numeros save(Numeros numeros) {
		Numeros nuevosNumeros = numerosRepository.save(numeros);
		return nuevosNumeros;
	}*/
}
