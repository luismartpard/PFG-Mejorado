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

import com.luis.GestorTaller.Model.Mecanico;
import com.luis.GestorTaller.ServiceImpl.MecanicoServiceImpl;

@RestController
@RequestMapping(value = "/api/mecanicos")
@CrossOrigin(value = "*")
public class MecanicoController {

	@Autowired
	private MecanicoServiceImpl mecanicoServiceImpl;

//	Post
	@PostMapping(value = "/nuevo")
	public Mecanico nuevoMecanico(@RequestBody Mecanico mecanico) {
		return this.mecanicoServiceImpl.nuevoMecanico(mecanico);
	}

//	Get
	@GetMapping(value = "/listado")
	public Page<Object> listadoMecanicos(Pageable pageable) {
		return this.mecanicoServiceImpl.listadoMecanicos(pageable);
	}
	
	@GetMapping(value = "/buscar/{nombre}")
	public Page<Object> buscarPorNombre(@PathVariable("nombre") String nombre, Pageable pageable) {
		return this.mecanicoServiceImpl.buscarPorNombre(nombre, pageable);
	}

	@GetMapping(value = "/recogerId/{dni}")
	public long returnIdMecanico(@PathVariable("dni") String dni) {
		return this.mecanicoServiceImpl.returnIdMecanico(dni);
	}
	
	@GetMapping(value = "/existe/dni/{dni}")
	public boolean existsMecanicoByDni(String dni) {
		return this.mecanicoServiceImpl.existsMecanicoByDni(dni);
	}
	
	@GetMapping(value = "/existe/telefono/{telefono}")
	public boolean existsMecanicoByTelefono(String telefono) {
		return this.mecanicoServiceImpl.existsMecanicoByTelefono(telefono);
	}
	
//	Put

//	Delete

}
