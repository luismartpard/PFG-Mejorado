package com.luis.GestorTaller.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.luis.GestorTaller.Model.Reparacion;

@Repository
public interface ReparacionRepository extends JpaRepository<Reparacion, Long> {

	@Query(value = "SELECT re.descripcion, re.precio, re.fecha_entrada, re.fecha_salida, re.estado "
			+ "FROM Reparacion as re", nativeQuery = false)
	public Page<Object> listadoReparaciones(Pageable pageable);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Reparacion as re SET re.mecanico.id = :idMec, re.estado = 1 WHERE re.id = :idRep", 
			nativeQuery = false)
	public void asignarMecanico(@Param("idRep") Long idRep, @Param("idMec") Long idMec);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Reparacion as re SET re.fecha_salida = NOW(), re.estado = 2 WHERE re.id = :idRep", nativeQuery = false)
	public void finalizarReparacion(@Param("idRep") Long idRep);
	
	@Query(value = "SELECT re.descripcion, re.precio, re.fecha_entrada, re.fecha_salida, re.estado "
			+ "FROM Reparacion as re WHERE re.id = :idRep", nativeQuery = false)
	public List<Object> buscarReparacion(@Param("idRep") Long idRep);
	
	@Query(value = "SELECT re.descripcion, re.precio, re.fecha_entrada, re.fecha_salida, re.estado "
			+ "FROM Reparacion as re ORDER BY re.id DESC", nativeQuery = false)
	public Page<Object> ultimasReparacions(Pageable pageable);
	
	public long count();

}
