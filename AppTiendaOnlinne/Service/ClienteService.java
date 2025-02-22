package org.example.spring.AppTiendaOnlinne.Service;

import org.example.spring.AppTiendaOnlinne.Cliente;
import org.example.spring.AppTiendaOnlinne.Respository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos(){
        return clienteRepository.findAll();
    }
    public Optional<Cliente>obtenerPorId(int id){
        return clienteRepository.findById(id);
    }
    public Cliente guardar(Cliente cliente){
        Optional<Cliente>existente=clienteRepository.findByNombre(cliente.getNombre());
        if (existente.isPresent()){
            throw new IllegalArgumentException("Ya existe un cliente con ese nombre");
        }
        return clienteRepository.save(cliente);
    }
    public boolean actualizar(Cliente nuevoCliente){
        Optional<Cliente>clienteExistente=clienteRepository.findById(nuevoCliente.getId());
        if (clienteExistente.isPresent()){
            clienteRepository.save(nuevoCliente);
            return true;
        }
        return false;
    }
    public boolean eliminar(int id){
        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
