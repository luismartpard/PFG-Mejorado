package com.luis.GestorTaller.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.luis.GestorTaller.Model.Marca;

public interface MarcaService {

	public Marca nuevaMarca(Marca marca);
	
	public Page<Object> listaMarcas(Pageable pageable);
	
	public List<Object> listaMarcas();
	
	public long recogerId(String marca);
	
	public Page<Object> buscarMarca(String marca, Pageable pageable);
	
	public boolean existsMarcaByNombre(String marca);
	
}
