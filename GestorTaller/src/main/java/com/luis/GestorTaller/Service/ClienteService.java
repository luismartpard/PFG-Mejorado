package com.luis.GestorTaller.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.luis.GestorTaller.Model.Cliente;

public interface ClienteService {

	public Cliente nuevoCliente(Cliente cliente);
	
	public Page<Object> listadoClientes(Pageable pageable);
	
	public Page<Object> buscarClientePorDNI(String dni, Pageable pageable);
	
	public Page<Object> buscarClientePorNombre(String nombre, Pageable pageable);
	
	public long count();
	
	public boolean existsClienteByDni(String dni);
	
	public boolean existsClienteByTelefono(String telefono);
	
}
