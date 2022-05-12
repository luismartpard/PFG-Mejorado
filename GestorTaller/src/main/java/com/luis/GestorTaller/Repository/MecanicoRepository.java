package com.luis.GestorTaller.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.luis.GestorTaller.Model.Mecanico;

@Repository
public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {

	@Query(value = "SELECT me.id, me.nombre, me.apellidos, me.telefono, me.dni "
			+ "FROM Mecanico as me", nativeQuery = false)
	public Page<Object> listadoMecanicos(Pageable pageable);
	
	@Query(value = "SELECT me.id FROM Mecanico as me WHERE me.dni = :dni", nativeQuery = false)
	public long returnIdMecanico(@Param("dni") String dni);
	
	@Query(value = "SELECT me.id, me.nombre, me.apellidos, me.telefono, me.dni "
			+ "FROM Mecanico as me WHERE LOWER(me.nombre) = :nombre", nativeQuery = false)
	public Page<Object> buscarPorNombre(@Param("nombre") String nombre, Pageable pageable);
	
	public boolean existsMecanicoByDni(String dni);
	
	public boolean existsMecanicoByTelefono(String telefono);
	
	
}
