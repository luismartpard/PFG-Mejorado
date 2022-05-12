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
@Table(name = "clientes")
public class Cliente extends Persona {

	@Id
	@Column(name = "id_cliente")
	@SequenceGenerator(name = "seq_gen_id_cliente", sequenceName = "seq_id_cliente", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	public Cliente(Long id, String nombre, String apellidos, String telefono, String dni) {
		super(nombre, apellidos, telefono, dni);
		this.id = id;
	}
	
}
