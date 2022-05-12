package com.luis.GestorTaller.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.luis.GestorTaller.Model.Mecanico;

public interface MecanicoService {

	public Mecanico nuevoMecanico(Mecanico mecanico);

	public Page<Object> listadoMecanicos(Pageable pageable);
	
	public Page<Object> buscarPorNombre(String nombre, Pageable pageable);
	
	public long returnIdMecanico(String dni);

	public boolean existsMecanicoByDni(String dni);

	public boolean existsMecanicoByTelefono(String telefono);

}
