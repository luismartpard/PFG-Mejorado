package com.luis.GestorTaller.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@Column(name = "id_usuario")
	@SequenceGenerator(name = "seq_gen_id_usuario", sequenceName = "seq_id_usuario", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull
	@Column(name = "usuario", length = 30, nullable = false, unique = true)
	private String usuario;
	
	@NotNull
	@Column(name = "contrasena", length = 255, nullable = false)
	private String contrasena;
	
}
