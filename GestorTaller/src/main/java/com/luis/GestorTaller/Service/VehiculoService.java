package com.luis.GestorTaller.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.luis.GestorTaller.Model.Vehiculo;

public interface VehiculoService {

	public Vehiculo nuevoVehiculo(Vehiculo vehiculo);
	
	public Page<Object> listadoVehiculos(Pageable pageable);
	
	public Page<Object> buscarPorMatricula(String matricula, Pageable pageable);
	
	public boolean existsVehiculoByMatricula(String matricula);
	
	public long count();
	
}
