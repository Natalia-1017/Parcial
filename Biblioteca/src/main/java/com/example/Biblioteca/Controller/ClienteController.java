package com.example.Biblioteca.Controller;

import com.example.Biblioteca.Model.Cliente;
import com.example.Biblioteca.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/todos")
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/id")
    public Cliente getClienteById(@PathVariable Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @PostMapping("/guardar")
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/id")
    public Cliente updateCliente(@PathVariable Integer id, @RequestBody Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setNombre(clienteDetails.getNombre());
            cliente.setApellido(clienteDetails.getApellido());
            cliente.setDireccion(clienteDetails.getDireccion());
            cliente.setTelefono(clienteDetails.getTelefono());
            cliente.setEmail(clienteDetails.getEmail());
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Integer id) {
        clienteRepository.deleteById(id);
    }
}
