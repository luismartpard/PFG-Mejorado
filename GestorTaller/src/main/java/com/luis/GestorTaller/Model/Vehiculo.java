package com.luis.GestorTaller.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vehiculos")
public class Vehiculo {

	@Id
	@Column(name = "id_vehiculo")
	@SequenceGenerator(name = "seq_gen_id_vehiculo", sequenceName = "seq_id_vehiculo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "matricula", length = 7, nullable = false, unique = true)
	private String matricula;
	
//	Relaciones
	
	@ManyToOne
	@JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo")
	@JsonIgnoreProperties(value = "modelos")
	private Modelo modelo;

	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	@JsonIgnoreProperties(value = "vehiculos")
	private Cliente cliente;

	@OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = "vehiculo")
	private List<Reparacion> reparaciones;
	
}
