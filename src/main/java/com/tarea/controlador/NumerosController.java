package com.tarea.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarea.entidad.Numeros;
import com.tarea.modelo.Suma;
import com.tarea.repositorio.NumerosRepository;
import com.tarea.servicio.NumerosService;

@Controller
@RequestMapping("/lista")
public class NumerosController {
	
	@Autowired
	private NumerosService numerosService;
	
	@GetMapping("/inicio")
	private String inicio(Model model) {
		Numeros numero = new Numeros();
		List<Suma> numeros = new ArrayList<Suma>();
		numeros = numerosService.getAll();
		model.addAttribute("numeros",numeros);
		model.addAttribute("numero",numero);
		return "index";
	}
	
	/*@GetMapping("/form")
	public String formulario(Model model) {
		Numeros numeros = new Numeros();
		model.addAttribute("numero",numeros);
		return "form";
	}*/
	
	@PostMapping("/inicio")
	public String guardar(Numeros numero, Model model) {
		numerosService.saveAll(numero);
		return "redirect:/lista/inicio";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if(id>0) {
			numerosService.delete(id);
		}
		return "redirect:/lista/inicio";
	}
	
}
