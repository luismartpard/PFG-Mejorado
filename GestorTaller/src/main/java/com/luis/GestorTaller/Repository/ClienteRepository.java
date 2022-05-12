package com.luis.GestorTaller.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.luis.GestorTaller.Model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query(value = "SELECT cli.id, cli.nombre, cli.apellidos, cli.telefono, cli.dni "
			+ "FROM Cliente as cli", nativeQuery = false)
	public Page<Object> listadoClientes(Pageable pageable);
	
	@Query(value = "SELECT cli.id, cli.nombre, cli.apellidos, cli.telefono, cli.dni "
			+ "FROM Cliente as cli WHERE cli.dni LIKE %:dni%", nativeQuery = false)
	public Page<Object> buscarClientePorDNI(@Param("dni") String dni, Pageable pageable);

	@Query(value = "SELECT cli.id, cli.nombre, cli.apellidos, cli.telefono, cli.dni "
			+ "FROM Cliente as cli WHERE LOWER(cli.nombre) LIKE %:nombre% ", nativeQuery = false)
	public Page<Object> buscarClientePorNombre(@Param("nombre") String nombre, Pageable pageable);
	
	public long count();

	public boolean existsClienteByDni(String dni);
	
	public boolean existsClienteByTelefono(String telefono);
	
}
