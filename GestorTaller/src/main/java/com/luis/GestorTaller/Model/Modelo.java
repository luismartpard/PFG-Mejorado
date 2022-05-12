package com.luis.GestorTaller.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "modelos")
public class Modelo {

	@Id
	@Column(name = "id_modelo")
	@SequenceGenerator(name = "seq_gen_id_modelo", sequenceName = "seq_id_modelo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull
	@Column(name = "nombre", length = 30, nullable = false, unique = true)
	private String nombre;
	
//	Relaciones

	@ManyToOne
	@JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
	@JsonIgnoreProperties(value = "modelos")
	private Marca marca;
	
}
