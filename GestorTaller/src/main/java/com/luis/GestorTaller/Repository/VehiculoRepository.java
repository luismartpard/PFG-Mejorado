package com.luis.GestorTaller.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.luis.GestorTaller.Model.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

	@Query(value = "SELECT ve.modelo.marca.nombre, ve.modelo.nombre, ve.matricula, ve.cliente.dni "
			+ "FROM Vehiculo as ve", nativeQuery = false)
	public Page<Object> listadoVehiculos(Pageable pageable);
	
	@Query(value = "SELECT ve.modelo.marca.nombre, ve.modelo.nombre, ve.matricula, ve.cliente.dni "
			+ "FROM Vehiculo as ve WHERE ve.matricula = :matricula", nativeQuery = false)
	public Page<Object> buscarPorMatricula(@Param("matricula") String matricula, Pageable pageable);
	
	public boolean existsVehiculoByMatricula(String matricula);
	
	public long count();
	
}
