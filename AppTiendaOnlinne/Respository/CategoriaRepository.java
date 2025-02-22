package org.example.spring.AppTiendaOnlinne.Respository;

import org.example.spring.AppTiendaOnlinne.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
    Optional<Categoria> findByNombre(String nombre);

}
