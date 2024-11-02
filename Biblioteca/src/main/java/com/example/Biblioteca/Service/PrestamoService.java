package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Prestamo;
import com.example.Biblioteca.Repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    public Optional<Prestamo> getPrestamoById(Integer id) {
        return prestamoRepository.findById(id);
    }

    public Prestamo createPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public Prestamo updatePrestamo(Integer id, Prestamo prestamoDetails) {
        return prestamoRepository.findById(id)
                .map(prestamo -> {
                    prestamo.setFechaPrestamo(prestamoDetails.getFechaPrestamo());
                    prestamo.setFechaDevolucion(prestamoDetails.getFechaDevolucion());
                    prestamo.setLibro(prestamoDetails.getLibro());
                    prestamo.setCliente(prestamoDetails.getCliente());
                    return prestamoRepository.save(prestamo);
                }).orElse(null);
    }

    public void deletePrestamo(Integer id) {
        prestamoRepository.deleteById(id);
    }

    public List<Prestamo> getPrestamosByClienteId(Integer clienteId) {
        return prestamoRepository.findPrestamosByClienteId(clienteId);
    }

    public List<Prestamo> getPrestamosByAutorId(Integer autorId) {
        return prestamoRepository.findPrestamosByAutorId(autorId);
    }
}

