package com.luis.GestorTaller.Model;

import java.util.Date;

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
@Table(name = "reparacion")
public class Reparacion {

	@Id
	@Column(name = "id_reparacion")
	@SequenceGenerator(name = "seq_gen_id_reparacion", sequenceName = "seq_id_reparacion", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull
	@Column(name = "descripcion", length = 60, nullable = false)
	private String descripcion;
	
	@NotNull
	@Column(name = "precio", nullable = true, columnDefinition = "DECIMAL (10,2)")
	private double precio;
	
	@NotNull
	@Column(name = "fecha_entrada", nullable = false)
	private Date fecha_entrada;
	
	@Column(name = "fecha_salida", nullable = true)
	private Date fecha_salida;
	
	@NotNull
	@Column(name = "estado", nullable = false)
	private short estado = 0;
	
//	Relaciones
	
	@ManyToOne
	@JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
	@JsonIgnoreProperties(value = "reparaciones")
	private Vehiculo vehiculo;
	
	@ManyToOne
	@JoinColumn(name = "id_mecanico", referencedColumnName = "id_mecanico")
	@JsonIgnoreProperties(value = "reparaciones")
	private Mecanico mecanico;
	
	
}
