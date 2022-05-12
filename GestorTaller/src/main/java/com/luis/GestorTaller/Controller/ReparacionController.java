package com.luis.GestorTaller.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luis.GestorTaller.Model.Reparacion;
import com.luis.GestorTaller.ServiceImpl.ReparacionServiceImpl;

@RestController
@RequestMapping(value = "/api/reparaciones")
@CrossOrigin(value = "*")
public class ReparacionController {

	@Autowired
	private ReparacionServiceImpl reparacionServiceImpl;
	
//	Post
	@PostMapping(value = "/nuevo")
	public Reparacion nuevaReparacion(@RequestBody Reparacion reparacion) {
		return this.reparacionServiceImpl.nuevaReparacion(reparacion);
	}
	
//	Get
	@GetMapping(value = "/listado")
	public Page<Object> listadoReparaciones(Pageable pageable) {
		return this.reparacionServiceImpl.listadoReparaciones(pageable);
	}
	
	@GetMapping(value = "/buscar/{idRep}")
	public List<Object> buscarReparacion(@PathVariable("idRep") Long idRep) {
		return this.reparacionServiceImpl.buscarReparacion(idRep);
	}
	
	@GetMapping(value = "/ultimas")
	public Page<Object> ultimasReparacions(Pageable pageable) {
		return this.reparacionServiceImpl.ultimasReparacions(pageable);
	}
	
	@GetMapping(value = "/total")
	public long count() {
		return this.reparacionServiceImpl.count();
	}
	
//	Put
	@PutMapping(value = "/asignar/{idRep},{idMec}")
	public void asignarMecanico(@PathVariable("idRep") Long idRep, @PathVariable("idMec") Long idMec) {
		this.reparacionServiceImpl.asignarMecanico(idRep, idMec);
	}
	
	@PutMapping(value = "/finalizar/{idRep}")
	public void finalizarReparacion(@PathVariable("idRep") Long idRep) {
		this.reparacionServiceImpl.finalizarReparacion(idRep);
	}
	
	
//	Delete
	
}
