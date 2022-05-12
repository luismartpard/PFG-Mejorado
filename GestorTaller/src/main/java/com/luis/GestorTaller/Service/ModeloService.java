package com.luis.GestorTaller.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.luis.GestorTaller.Model.Modelo;

public interface ModeloService {

	public Modelo nuevoModelo(Modelo modelo);
	
	public Page<Object> listadoModelos(Pageable pageable);
	
	public boolean existsModeloByNombre(String modelo);
	
}
