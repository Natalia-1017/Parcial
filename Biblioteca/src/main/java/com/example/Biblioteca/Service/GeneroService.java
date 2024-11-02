package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Genero;
import com.example.Biblioteca.Repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> getAllGeneros() {
        return generoRepository.findAll();
    }

    public Optional<Genero> getGeneroById(Integer id) {
        return generoRepository.findById(id);
    }

    public Genero createGenero(Genero genero) {
        return generoRepository.save(genero);
    }

    public Genero updateGenero(Integer id, Genero generoDetails) {
        return generoRepository.findById(id)
                .map(genero -> {
                    genero.setNombreGenero(generoDetails.getNombreGenero());
                    return generoRepository.save(genero);
                }).orElse(null);
    }

    public void deleteGenero(Integer id) {
        generoRepository.deleteById(id);
    }
}

