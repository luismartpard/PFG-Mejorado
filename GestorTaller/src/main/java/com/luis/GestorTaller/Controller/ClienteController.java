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

import com.luis.GestorTaller.Model.Cliente;
import com.luis.GestorTaller.ServiceImpl.ClienteServiceImpl;

@RestController
@RequestMapping(value = "/api/clientes")
@CrossOrigin(value = "*")
public class ClienteController {

	@Autowired
	private ClienteServiceImpl clienteServiceImpl;

//	Post
	@PostMapping(value = "/nuevo")
	public Cliente nuevoCliente(@RequestBody Cliente cliente) {
		return this.clienteServiceImpl.nuevoCliente(cliente);
	}

//	Get
	@GetMapping(value = "/listado")
	public Page<Object> listadoClientes(Pageable pageable) {
		return this.clienteServiceImpl.listadoClientes(pageable);
	}
	
	@GetMapping(value = "/buscar/dni/{dni}")
	public Page<Object> buscarClientePorDNI(@PathVariable("dni") String dni, Pageable pageable) {
		return this.clienteServiceImpl.buscarClientePorDNI(dni, pageable);
	}
	
	@GetMapping(value = "/buscar/nombre/{nombre}")
	public Page<Object> buscarClientePorNombre(@PathVariable("nombre") String nombre, Pageable pageable) {
		return this.clienteServiceImpl.buscarClientePorNombre(nombre, pageable);
	}
	
	@GetMapping(value = "/total")
	public long count() {
		return this.clienteServiceImpl.count();
	}

//	Put

//	Delete

}
