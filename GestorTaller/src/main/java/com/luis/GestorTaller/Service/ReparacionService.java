package com.luis.GestorTaller.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.luis.GestorTaller.Model.Reparacion;

public interface ReparacionService {

	public Reparacion nuevaReparacion(Reparacion reparacion);
	
	public Page<Object> listadoReparaciones(Pageable pageable);
	
	public void asignarMecanico(Long idRep, Long idMec);
	
	public void finalizarReparacion(Long idRep);

	public List<Object> buscarReparacion(Long idRep);
	
	public Page<Object> ultimasReparacions(Pageable pageable);
	
	public long count();
	
}
