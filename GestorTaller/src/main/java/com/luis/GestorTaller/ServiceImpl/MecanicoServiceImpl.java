package com.luis.GestorTaller.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.luis.GestorTaller.Model.Mecanico;
import com.luis.GestorTaller.Repository.MecanicoRepository;
import com.luis.GestorTaller.Service.MecanicoService;

@Service
public class MecanicoServiceImpl implements MecanicoService {

	@Autowired
	private MecanicoRepository mecanicoRepository;

	@Override
	public Mecanico nuevoMecanico(Mecanico mecanico) {
		return this.mecanicoRepository.save(mecanico);
	}

	@Override
	public Page<Object> listadoMecanicos(Pageable pageable) {
		return this.mecanicoRepository.listadoMecanicos(pageable);
	}

	@Override
	public Page<Object> buscarPorNombre(String nombre, Pageable pageable) {
		return this.mecanicoRepository.buscarPorNombre(nombre, pageable);
	}

	@Override
	public long returnIdMecanico(String dni) {
		return this.mecanicoRepository.returnIdMecanico(dni);
	}

	@Override
	public boolean existsMecanicoByDni(String dni) {
		return this.mecanicoRepository.existsMecanicoByDni(dni);
	}

	@Override
	public boolean existsMecanicoByTelefono(String telefono) {
		return this.mecanicoRepository.existsMecanicoByTelefono(telefono);
	}
		
}
