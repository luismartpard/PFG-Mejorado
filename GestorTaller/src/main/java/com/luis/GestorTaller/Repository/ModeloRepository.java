package com.luis.GestorTaller.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luis.GestorTaller.Model.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

	@Query(value = "SELECT mo.marca.nombre, mo.nombre FROM Modelo as mo", nativeQuery = false)
	public Page<Object> listadoModelos(Pageable pageable);

	public boolean existsModeloByNombre(String modelo);
	
}
