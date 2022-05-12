package com.luis.GestorTaller.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.luis.GestorTaller.Model.Marca;
import com.luis.GestorTaller.Repository.MarcaRepository;
import com.luis.GestorTaller.Service.MarcaService;

@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;

	@Override
	public Marca nuevaMarca(Marca marca) {
		return this.marcaRepository.save(marca);
	}

	@Override
	public Page<Object> listaMarcas(Pageable pageable) {
		return this.marcaRepository.listaMarcas(pageable);
	}

	@Override
	public List<Object> listaMarcas() {
		return this.marcaRepository.listaMarcas();
	}

	@Override
	public long recogerId(String marca) {
		return this.marcaRepository.count();
	}

	@Override
	public Page<Object> buscarMarca(String marca, Pageable pageable) {
		return this.marcaRepository.buscarMarca(marca, pageable);
	}

	@Override
	public boolean existsMarcaByNombre(String marca) {
		return this.marcaRepository.existsMarcaByNombre(marca);
	}

}
