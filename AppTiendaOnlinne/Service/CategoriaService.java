package org.example.spring.AppTiendaOnlinne.Service;

import org.example.spring.AppTiendaOnlinne.Categoria;
import org.example.spring.AppTiendaOnlinne.Respository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> obtenerTodos(){
        return categoriaRepository.findAll();
    }
    public Optional<Categoria>obtenerPorId(Integer id){
        return categoriaRepository.findById(id);
    }
    public Categoria guardar(Categoria categoria){
        Optional<Categoria>existente=categoriaRepository.findByNombre(categoria.getNombre());
        if (existente.isPresent()){
            throw new IllegalArgumentException("Ya existe una categoría con ese nombre");
        }
        return categoriaRepository.save(categoria);
    }
    public boolean actualizar(Categoria nuevaCategoria){
        Optional<Categoria>categoriaExistente=categoriaRepository.findById(nuevaCategoria.getId());
        if (categoriaExistente.isPresent()){
            categoriaRepository.save(nuevaCategoria);
            return true;
        }
        return false;
    }
    public boolean eliminar(Integer id){
        if (categoriaRepository.existsById(id)){
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
