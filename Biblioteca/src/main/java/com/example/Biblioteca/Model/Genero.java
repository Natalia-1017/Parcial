package com.example.Biblioteca.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Generos")

public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombreGenero;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Libro> libros;


    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombreGenero() { return nombreGenero; }
    public void setNombreGenero(String nombreGenero) { this.nombreGenero = nombreGenero; }
    public List<Libro> getLibros() { return libros; }
    public void setLibros(List<Libro> libros) { this.libros = libros; }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", nombreGenero='" + nombreGenero + '\'' +
                '}';
    }
}
