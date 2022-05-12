package com.luis.GestorTaller.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.luis.GestorTaller.Model.Vehiculo;
import com.luis.GestorTaller.Repository.VehiculoRepository;
import com.luis.GestorTaller.Service.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService {

	@Autowired
	private VehiculoRepository vehiculoRepository;

	@Override
	public Vehiculo nuevoVehiculo(Vehiculo vehiculo) {
		return this.vehiculoRepository.save(vehiculo);
	}

	@Override
	public Page<Object> listadoVehiculos(Pageable pageable) {
		return this.vehiculoRepository.listadoVehiculos(pageable);
	}

	@Override
	public Page<Object> buscarPorMatricula(String matricula, Pageable pageable) {
		return this.vehiculoRepository.buscarPorMatricula(matricula, pageable);
	}

	@Override
	public boolean existsVehiculoByMatricula(String matricula) {
		return this.vehiculoRepository.existsVehiculoByMatricula(matricula);
	}

	@Override
	public long count() {
		return this.vehiculoRepository.count();
	}

}
