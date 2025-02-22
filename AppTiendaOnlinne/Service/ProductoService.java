package org.example.spring.AppTiendaOnlinne.Service;

import org.example.spring.AppTiendaOnlinne.Producto;
import org.example.spring.AppTiendaOnlinne.Respository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos(){
        return productoRepository.findAll();
    }
    public Optional<Producto>obtenerPorId(int id){
        return productoRepository.findById(id);
    }
    public Producto guardar(Producto producto){
        Optional<Producto>existente=productoRepository.findByNombre(producto.getNombre());
        if (existente.isPresent()){
            throw new IllegalArgumentException("El nombre de este producto ya existe");
        }
        return productoRepository.save(producto);
    }
    public boolean actualizar(Producto nuevoProducto){
        Optional<Producto>productoExistente=productoRepository.findById(nuevoProducto.getId());
        if (productoExistente.isPresent()){
            productoRepository.save(nuevoProducto);
            return true;
        }
        return false;
    }
    public boolean eliminar(int id){
        if (productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
