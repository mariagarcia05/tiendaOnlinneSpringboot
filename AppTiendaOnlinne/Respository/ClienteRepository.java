package org.example.spring.AppTiendaOnlinne.Respository;

import org.example.spring.AppTiendaOnlinne.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    Optional<Cliente>findByNombre(String nombre);
}
