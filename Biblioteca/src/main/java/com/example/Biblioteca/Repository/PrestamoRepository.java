package com.example.Biblioteca.Repository;

import com.example.Biblioteca.Model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

    // Consulta 1: Obtener préstamos junto con información del libro y cliente
    @Query("SELECT p FROM Prestamo p JOIN FETCH p.libro l JOIN FETCH p.cliente c WHERE c.id = :clienteId")
    List<Prestamo> findPrestamosByClienteId(@Param("clienteId") Integer clienteId);

    // Consulta 2: Obtener préstamos junto con la información completa de los autores de los libros prestados
    @Query("SELECT p FROM Prestamo p JOIN FETCH p.libro l JOIN FETCH l.autor a WHERE a.id = :autorId")
    List<Prestamo> findPrestamosByAutorId(@Param("autorId") Integer autorId);

    // Consulta 3: Relación de Clientes, Préstamos y Libros usando consulta nativa
    @Query(value = "SELECT c.nombre AS Cliente_Nombre, c.apellido AS Cliente_Apellido, " +
            "l.titulo AS Libro_Titulo, p.fecha_prestamo, p.fecha_devolucion " +
            "FROM prestamos p " +
            "JOIN clientes c ON p.cliente_id = c.id " +
            "JOIN libros l ON p.libro_id = l.id", nativeQuery = true)
    List<Object[]> findClientesPrestamosLibros();

    // Consulta 4: Relación de Géneros de Libros Prestados y Clientes usando consulta nativa
    @Query(value = "SELECT g.nombre_genero AS Genero, l.titulo AS Libro_Titulo, " +
            "c.nombre AS Cliente_Nombre, c.apellido AS Cliente_Apellido, " +
            "p.fecha_prestamo, p.fecha_devolucion " +
            "FROM prestamos p " +
            "JOIN libros l ON p.libro_id = l.id " +
            "JOIN generos g ON l.genero_id = g.id " +
            "JOIN clientes c ON p.cliente_id = c.id", nativeQuery = true)
    List<Object[]> findGenerosLibrosClientes();
}


