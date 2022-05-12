package com.luis.GestorTaller.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mecanicos")
public class Mecanico extends Persona {

	@Id
	@Column(name = "id_mecanico")
	@SequenceGenerator(name = "seq_gen_id_mecanico", sequenceName = "seq_id_mecanico", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	public Mecanico(Long id, String nombre, String apellidos, String telefono, String dni) {
		super(nombre, apellidos, telefono, dni);
		this.id = id;
	}
	
}
