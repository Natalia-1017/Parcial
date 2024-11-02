package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    public Optional<Libro> getLibroById(Integer id) {
        return libroRepository.findById(id);
    }

    public Libro createLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro updateLibro(Integer id, Libro libroDetails) {
        return libroRepository.findById(id)
                .map(libro -> {
                    libro.setTitulo(libroDetails.getTitulo());
                    libro.setAñoPublicacion(libroDetails.getAñoPublicacion());
                    libro.setIsbn(libroDetails.getIsbn());
                    libro.setDisponibilidad(libroDetails.getDisponibilidad());
                    libro.setAutor(libroDetails.getAutor());
                    libro.setGenero(libroDetails.getGenero());
                    return libroRepository.save(libro);
                }).orElse(null);
    }

    public void deleteLibro(Integer id) {
        libroRepository.deleteById(id);
    }
}

