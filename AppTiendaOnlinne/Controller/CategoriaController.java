package org.example.spring.AppTiendaOnlinne.Controller;

import jakarta.validation.Valid;
import org.example.spring.AppTiendaOnlinne.Categoria;
import org.example.spring.AppTiendaOnlinne.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
@CacheConfig(cacheNames = {"categoria"})
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>>obtenerTodos(){
        List<Categoria>categorias=categoriaService.obtenerTodos();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Optional<Categoria>>obtenerCategoriaPorId(@PathVariable int id){
        try {
            Thread.sleep(3000);
            Optional<Categoria>categoria=categoriaService.obtenerPorId(id);
            return new ResponseEntity<>(categoria,HttpStatus.OK);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    @PostMapping
    public ResponseEntity<String> guardar(@RequestBody @Valid Categoria categoria) {
        try {
            Categoria categoriaGuardar = categoriaService.guardar(categoria);
            return ResponseEntity.ok("Categoría guardada con éxito");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno al guardar la categoría");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>actualizar(@RequestBody Categoria nuevaCategoria){
        boolean actualizado=categoriaService.actualizar(nuevaCategoria);
        if (actualizado){
            return ResponseEntity.ok("categoria actualizada con exito");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("categoria no encontrada");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>eliminar(@PathVariable int id){
        boolean eliminado=categoriaService.eliminar(id);
        if (eliminado){
            return ResponseEntity.ok("categoría eliminada con exito");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("categoría no encontrada");
        }
    }


}
