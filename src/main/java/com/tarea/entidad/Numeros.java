package com.tarea.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Numeros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero1;
	private int numero2;
	
	public Numeros() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public int getSuma() {
		return (this.numero1 + this.numero2);
	}
}
