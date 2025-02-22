package org.example.spring.AppTiendaOnlinne.Respository;

import org.example.spring.AppTiendaOnlinne.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    Optional<Producto> findByNombre(String nombre);
}
