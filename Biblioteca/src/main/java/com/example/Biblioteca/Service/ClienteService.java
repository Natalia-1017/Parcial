package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Cliente;
import com.example.Biblioteca.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteById(Integer id) {
        return clienteRepository.findById(id);
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Integer id, Cliente clienteDetails) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNombre(clienteDetails.getNombre());
                    cliente.setApellido(clienteDetails.getApellido());
                    cliente.setDireccion(clienteDetails.getDireccion());
                    cliente.setTelefono(clienteDetails.getTelefono());
                    cliente.setEmail(clienteDetails.getEmail());
                    return clienteRepository.save(cliente);
                }).orElse(null);
    }

    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}

