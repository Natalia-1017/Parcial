package com.example.Biblioteca.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Libros")

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private Integer añoPublicacion;
    private String isbn;
    private Boolean disponibilidad;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Prestamo> prestamos;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public Integer getAñoPublicacion() { return añoPublicacion; }
    public void setAñoPublicacion(Integer añoPublicacion) { this.añoPublicacion = añoPublicacion; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public Boolean getDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(Boolean disponibilidad) { this.disponibilidad = disponibilidad; }
    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }
    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) { this.genero = genero; }
    public List<Prestamo> getPrestamos() { return prestamos; }
    public void setPrestamos(List<Prestamo> prestamos) { this.prestamos = prestamos; }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", añoPublicacion=" + añoPublicacion +
                ", isbn='" + isbn + '\'' +
                ", disponibilidad=" + disponibilidad +
                ", autor=" + (autor != null ? autor.getNombre() : "N/A") +
                ", genero=" + (genero != null ? genero.getNombreGenero() : "N/A") +
                '}';
    }
}
