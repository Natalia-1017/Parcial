package com.example.Biblioteca.Repository;

import com.example.Biblioteca.Model.Libro;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
}

