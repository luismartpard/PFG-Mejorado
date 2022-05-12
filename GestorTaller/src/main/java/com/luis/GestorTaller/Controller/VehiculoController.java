package com.luis.GestorTaller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luis.GestorTaller.Model.Vehiculo;
import com.luis.GestorTaller.ServiceImpl.VehiculoServiceImpl;

@RestController
@RequestMapping(value = "/api/vehiculos")
@CrossOrigin(value = "*")
public class VehiculoController {

	@Autowired
	private VehiculoServiceImpl vehiculoServiceImpl;
	
//	Post
	@PostMapping(value = "/nuevo")
	public Vehiculo nuevoVehiculo(@RequestBody Vehiculo vehiculo) {
		return this.vehiculoServiceImpl.nuevoVehiculo(vehiculo);
	}
	
//	Get
	@GetMapping(value = "/listado")
	public Page<Object> listadoVehiculos(Pageable pageable) {
		return this.vehiculoServiceImpl.listadoVehiculos(pageable);
	}
	
	@GetMapping(value = "/buscar/{matricula}")
	public Page<Object> buscarPorMatricula(@PathVariable("matricula") String matricula, Pageable pageable) {
		return this.vehiculoServiceImpl.buscarPorMatricula(matricula, pageable);
	}
	
	@GetMapping(value = "/existe/{matricula}")
	public boolean existsVehiculoByMatricula(@PathVariable("matricula") String matricula) {
		return this.vehiculoServiceImpl.existsVehiculoByMatricula(matricula);
	}
	
	@GetMapping(value = "/total")
	public long count() {
		return this.vehiculoServiceImpl.count();
	}
	
//	Put
	
//	Delete
	
}
