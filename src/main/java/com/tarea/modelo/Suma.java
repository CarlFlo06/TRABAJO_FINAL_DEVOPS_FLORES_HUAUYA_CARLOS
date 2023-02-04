package com.tarea.modelo;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Suma {

	private Long id;
	private int numero1;
	private int numero2;
	
	public Suma() {
		// TODO Auto-generated constructor stub
	}
	
	public int getSuma() {
		return (this.numero1 + this.numero2);
	}
}
