package com.example.Biblioteca.Controller;

import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @GetMapping("/id")
    public Libro getLibroById(@PathVariable Integer id) {
        return libroRepository.findById(id).orElse(null);
    }

    @PostMapping("/guardar")
    public Libro createLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @PutMapping("/id")
    public Libro updateLibro(@PathVariable Integer id, @RequestBody Libro libroDetails) {
        Libro libro = libroRepository.findById(id).orElse(null);
        if (libro != null) {
            libro.setTitulo(libroDetails.getTitulo());
            libro.setAñoPublicacion(libroDetails.getAñoPublicacion());
            libro.setIsbn(libroDetails.getIsbn());
            libro.setDisponibilidad(libroDetails.getDisponibilidad());
            libro.setAutor(libroDetails.getAutor());
            libro.setGenero(libroDetails.getGenero());
            return libroRepository.save(libro);
        }
        return null;
    }

    @DeleteMapping("/id")
    public void deleteLibro(@PathVariable Integer id) {
        libroRepository.deleteById(id);
    }
}

