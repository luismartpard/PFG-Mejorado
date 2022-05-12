package com.luis.GestorTaller.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.luis.GestorTaller.Model.Cliente;
import com.luis.GestorTaller.Repository.ClienteRepository;
import com.luis.GestorTaller.Service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente nuevoCliente(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Override
	public Page<Object> listadoClientes(Pageable pageable) {
		return this.clienteRepository.listadoClientes(pageable);
	}

	@Override
	public Page<Object> buscarClientePorDNI(String dni, Pageable pageable) {
		return this.clienteRepository.buscarClientePorDNI(dni, pageable);
	}

	@Override
	public Page<Object> buscarClientePorNombre(String nombre, Pageable pageable) {
		return this.clienteRepository.buscarClientePorNombre(nombre, pageable);
	}

	@Override
	public long count() {
		return this.clienteRepository.count();
	}

	@Override
	public boolean existsClienteByDni(String dni) {
		return this.clienteRepository.existsClienteByDni(dni);
	}

	@Override
	public boolean existsClienteByTelefono(String telefono) {
		return this.clienteRepository.existsClienteByTelefono(telefono);
	}
	
	

}
