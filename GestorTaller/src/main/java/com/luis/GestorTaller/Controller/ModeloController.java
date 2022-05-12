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

import com.luis.GestorTaller.Model.Modelo;
import com.luis.GestorTaller.ServiceImpl.ModeloServiceImpl;

@RestController
@RequestMapping(value = "/api/modelos")
@CrossOrigin(value = "*")
public class ModeloController {

	@Autowired
	private ModeloServiceImpl modeloServiceImpl;
	
//	Post
	@PostMapping(value = "/nuevo")
	public Modelo nuevoModelo(@RequestBody Modelo modelo) {
		return this.modeloServiceImpl.nuevoModelo(modelo);
	}
	
//	Get
	@GetMapping(value = "/listado")
	public Page<Object> listadoModelos(Pageable pageable) {
		return this.modeloServiceImpl.listadoModelos(pageable);
	}
	
	@GetMapping(value = "/comprobar/{modelo}")
	public boolean existsModeloByNombre(@PathVariable("modelo") String modelo) {
		return this.modeloServiceImpl.existsModeloByNombre(modelo);
	}
	
//	Put
	
//	Delete
	
}
