package com.luis.GestorTaller.Controller;

import java.util.List;

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

import com.luis.GestorTaller.Model.Marca;
import com.luis.GestorTaller.ServiceImpl.MarcaServiceImpl;

@RestController
@RequestMapping(value = "/api/marcas")
@CrossOrigin(value = "*")
public class MarcaController {

	@Autowired
	private MarcaServiceImpl marcaServiceImpl;

//	Post
	@PostMapping(value = "/nuevo")
	public Marca nuevaMarca(@RequestBody Marca marca) {
		return this.marcaServiceImpl.nuevaMarca(marca);
	}

//	Get
	@GetMapping(value = "/listado")
	public Page<Object> listaMarcas(Pageable pageable) {
		return this.marcaServiceImpl.listaMarcas(pageable);
	}
	
	@GetMapping(value = "/select")
	public List<Object> listaMarcas() {
		return this.marcaServiceImpl.listaMarcas();
	}
	
	@GetMapping(value = "/recogerId/{marca}")
	public long recogerId(@PathVariable("marca") String marca) {
		return this.marcaServiceImpl.recogerId(marca);
	}
	
	@GetMapping(value = "/buscar/{marca}")
	public Page<Object> buscarMarca(@PathVariable("marca") String marca, Pageable pageable) {
		return this.marcaServiceImpl.buscarMarca(marca, pageable);
	}
	
	@GetMapping(value = "/existeMarca/{marca}")
	public boolean existsMarcaByNombre(@PathVariable("marca") String marca) {
		return this.marcaServiceImpl.existsMarcaByNombre(marca);
	}

//	Put

//	Delete

}
