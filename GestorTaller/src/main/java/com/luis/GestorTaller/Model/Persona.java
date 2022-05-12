package com.luis.GestorTaller.Model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class Persona {
	
	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;

	@Column(name = "apellidos", length = 60, nullable = false)
	private String apellidos;
	
	@Column(name = "telefono", length = 9, nullable = false, unique = true)
	private String telefono;
	
	@Column(name = "dni", length = 9, nullable = false, unique = false)
	private String dni;
	
}
