package com.luis.GestorTaller.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.luis.GestorTaller.Model.Modelo;
import com.luis.GestorTaller.Repository.ModeloRepository;
import com.luis.GestorTaller.Service.ModeloService;

@Service
public class ModeloServiceImpl implements ModeloService {

	@Autowired
	private ModeloRepository modeloRepository;

	@Override
	public Modelo nuevoModelo(Modelo modelo) {
		return this.modeloRepository.save(modelo);
	}

	@Override
	public Page<Object> listadoModelos(Pageable pageable) {
		return this.modeloRepository.listadoModelos(pageable);
	}

	@Override
	public boolean existsModeloByNombre(String modelo) {
		return this.modeloRepository.existsModeloByNombre(modelo);
	}
	
}
