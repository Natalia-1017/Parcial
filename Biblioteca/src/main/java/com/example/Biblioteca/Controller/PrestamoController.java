package com.example.Biblioteca.Controller;
import com.example.Biblioteca.Model.Prestamo;
import com.example.Biblioteca.Repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoRepository prestamoRepository;


    @GetMapping("/id")
    public Prestamo getPrestamoById(@PathVariable Integer id) {
        return prestamoRepository.findById(id).orElse(null);
    }

    @PostMapping("/guardar")
    public Prestamo createPrestamo(@RequestBody Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @PutMapping("/id")
    public Prestamo updatePrestamo(@PathVariable Integer id, @RequestBody Prestamo prestamoDetails) {
        Prestamo prestamo = prestamoRepository.findById(id).orElse(null);
        if (prestamo != null) {
            prestamo.setFechaPrestamo(prestamoDetails.getFechaPrestamo());
            prestamo.setFechaDevolucion(prestamoDetails.getFechaDevolucion());
            prestamo.setLibro(prestamoDetails.getLibro());
            prestamo.setCliente(prestamoDetails.getCliente());
            return prestamoRepository.save(prestamo);
        }
        return null;
    }

    @DeleteMapping("/id")
    public void deletePrestamo(@PathVariable Integer id) {
        prestamoRepository.deleteById(id);
    }

    @GetMapping("/cliente/clienteId")
    public List<Prestamo> getPrestamosByCliente(@PathVariable Integer clienteId) {
        return prestamoRepository.findPrestamosByClienteId(clienteId);
    }

    @GetMapping("/autor/autorId")
    public List<Prestamo> getPrestamosByAutor(@PathVariable Integer autorId) {
        return prestamoRepository.findPrestamosByAutorId(autorId);
    }

    @GetMapping("/clientes-prestamos-libros")
    public List<Object[]> getClientesPrestamosLibros() {
        return prestamoRepository.findClientesPrestamosLibros();
    }

    @GetMapping("/generos-libros-clientes")
    public List<Object[]> getGenerosLibrosClientes() {
        return prestamoRepository.findGenerosLibrosClientes();
    }
}

