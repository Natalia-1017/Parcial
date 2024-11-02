package com.example.Biblioteca.Controller;

import com.example.Biblioteca.Model.Autor;
import com.example.Biblioteca.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/todos")
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    @GetMapping("/(id)")
    public Autor getAutorById(@PathVariable Integer id) {
        return autorRepository.findById(id).orElse(null);
    }

    @PostMapping ("/guardar")
    public Autor createAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    @PutMapping("/id")
    public Autor updateAutor(@PathVariable Integer id, @RequestBody Autor autorDetails) {
        Autor autor = autorRepository.findById(id).orElse(null);
        if (autor != null) {
            autor.setNombre(autorDetails.getNombre());
            autor.setApellido(autorDetails.getApellido());
            autor.setNacionalidad(autorDetails.getNacionalidad());
            autor.setAñoNacimiento(autorDetails.getAñoNacimiento());
            return autorRepository.save(autor);
        }
        return null;
    }

    @DeleteMapping("/(id)")
    public void deleteAutor(@PathVariable Integer id) {
        autorRepository.deleteById(id);
    }
}
