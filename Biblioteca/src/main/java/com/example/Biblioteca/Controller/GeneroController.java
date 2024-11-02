package com.example.Biblioteca.Controller;


import com.example.Biblioteca.Model.Genero;
import com.example.Biblioteca.Repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping("/todos")
    public List<Genero> getAllGeneros() {
        return generoRepository.findAll();
    }

    @GetMapping("/id")
    public Genero getGeneroById(@PathVariable Integer id) {
        return generoRepository.findById(id).orElse(null);
    }

    @PostMapping("/guardar")
    public Genero createGenero(@RequestBody Genero genero) {
        return generoRepository.save(genero);
    }

    @PutMapping("/{id}")
    public Genero updateGenero(@PathVariable Integer id, @RequestBody Genero generoDetails) {
        Genero genero = generoRepository.findById(id).orElse(null);
        if (genero != null) {
            genero.setNombreGenero(generoDetails.getNombreGenero());
            return generoRepository.save(genero);
        }
        return null;
    }

    @DeleteMapping("/id")
    public void deleteGenero(@PathVariable Integer id) {
        generoRepository.deleteById(id);
    }
}
