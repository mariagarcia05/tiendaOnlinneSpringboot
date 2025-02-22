package org.example.spring.AppTiendaOnlinne.Controller;

import jakarta.validation.Valid;
import org.example.spring.AppTiendaOnlinne.Producto;
import org.example.spring.AppTiendaOnlinne.Respository.ProductoRepository;
import org.example.spring.AppTiendaOnlinne.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
@CacheConfig(cacheNames = {"producto"})
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>>obtenerTodos() {
        List<Producto> productos = productoService.obtenerTodos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    @GetMapping("{id}")
    @Cacheable
    public ResponseEntity<Optional<Producto>>obtenerPorId(@PathVariable int id){
        try {
            Thread.sleep(3000);
            Optional<Producto>producto=productoService.obtenerPorId(id);
            return new ResponseEntity<>(producto,HttpStatus.OK);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    @PostMapping
    public ResponseEntity<String>guardar(@RequestBody @Valid Producto producto){
        try {
            Producto productoGuardar=productoService.guardar(producto);
            return ResponseEntity.ok("producto añadido con éxito");
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno al guardar el producto");
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<String>actualizar(@RequestBody Producto nuevoProducto){
        boolean actualizado=productoService.actualizar(nuevoProducto);
        if (actualizado){
            return ResponseEntity.ok("producto actualizado con éxito");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("producto no actualizado");
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String>eliminar(@PathVariable int id){
        boolean eliminado= productoService.eliminar(id);
        if (eliminado){
            return ResponseEntity.ok("producto eliminado con exito");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("producto no encontrado");
        }
    }

}
