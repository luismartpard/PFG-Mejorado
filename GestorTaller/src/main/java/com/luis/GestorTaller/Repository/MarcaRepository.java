package com.luis.GestorTaller.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.luis.GestorTaller.Model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

	@Query(value = "SELECT ma.id, ma.nombre FROM Marca as ma", nativeQuery = false)
	public Page<Object> listaMarcas(Pageable pageable);

	@Query(value = "SELECT ma.id, ma.nombre FROM Marca as ma", nativeQuery = false)
	public List<Object> listaMarcas();

	@Query(value = "SELECT ma.id FROM Marca as ma WHERE ma.nombre = :marca", nativeQuery = false)
	public long recogerId(@Param("marca") String marca);

	@Query(value = "SELECT ma.id, ma.nombre FROM Marca as ma WHERE ma.nombre = :marca ", nativeQuery = false)
	public Page<Object> buscarMarca(@Param("marca") String marca, Pageable pageable);
	
	public boolean existsMarcaByNombre(String marca);
	
}
