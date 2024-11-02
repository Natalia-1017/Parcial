package com.example.Biblioteca.Service;


import com.example.Biblioteca.Model.Autor;
import com.example.Biblioteca.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    public Optional<Autor> getAutorById(Integer id) {
        return autorRepository.findById(id);
    }

    public Autor createAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor updateAutor(Integer id, Autor autorDetails) {
        return autorRepository.findById(id)
                .map(autor -> {
                    autor.setNombre(autorDetails.getNombre());
                    autor.setApellido(autorDetails.getApellido());
                    autor.setNacionalidad(autorDetails.getNacionalidad());
                    autor.setAñoNacimiento(autorDetails.getAñoNacimiento());
                    return autorRepository.save(autor);
                }).orElse(null);
    }

    public void deleteAutor(Integer id) {
        autorRepository.deleteById(id);
    }
}
