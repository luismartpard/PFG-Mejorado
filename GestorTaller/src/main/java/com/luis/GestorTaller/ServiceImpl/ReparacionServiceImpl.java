package com.luis.GestorTaller.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.luis.GestorTaller.Model.Reparacion;
import com.luis.GestorTaller.Repository.ReparacionRepository;
import com.luis.GestorTaller.Service.ReparacionService;

@Service
public class ReparacionServiceImpl implements ReparacionService {

	@Autowired
	private ReparacionRepository reparacionRepository;

	@Override
	public Reparacion nuevaReparacion(Reparacion reparacion) {
		return this.reparacionRepository.save(reparacion);
	}

	@Override
	public Page<Object> listadoReparaciones(Pageable pageable) {
		return this.reparacionRepository.listadoReparaciones(pageable);
	}

	@Override
	public void asignarMecanico(Long idRep, Long idMec) {
		this.reparacionRepository.asignarMecanico(idRep, idMec);
	}

	@Override
	public void finalizarReparacion(Long idRep) {
		this.reparacionRepository.finalizarReparacion(idRep);	
	}

	@Override
	public List<Object> buscarReparacion(Long idRep) {
		return this.reparacionRepository.buscarReparacion(idRep);
	}

	@Override
	public Page<Object> ultimasReparacions(Pageable pageable) {
		return this.reparacionRepository.ultimasReparacions(pageable);
	}

	@Override
	public long count() {
		return this.reparacionRepository.count();
	}
	
}
