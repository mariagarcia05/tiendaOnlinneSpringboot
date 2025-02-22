package org.example.spring.AppTiendaOnlinne.Controller;

import jakarta.validation.Valid;
import org.example.spring.AppTiendaOnlinne.Cliente;
import org.example.spring.AppTiendaOnlinne.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@CacheConfig(cacheNames = {"cliente"})
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>>obtenerTodos(){
        List<Cliente>clientes=clienteService.obtenerTodos();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Optional<Cliente>>obtenerPorId(@PathVariable int id){
        try{
            Thread.sleep(3000);
            Optional<Cliente>cliente=clienteService.obtenerPorId(id);
            return new ResponseEntity<>(cliente,HttpStatus.OK);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    @PostMapping
    public ResponseEntity<String>guardar(@RequestBody @Valid Cliente cliente){
        try{
            Cliente clienteGuardar=clienteService.guardar(cliente);
            return ResponseEntity.ok("cliente guardado con éxito");
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno al guardar el cliente");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String>actualizar(@RequestBody Cliente nuevoCliente){
        boolean actualizado=clienteService.actualizar(nuevoCliente);
        if (actualizado){
            return ResponseEntity.ok("cliente actualizado con éxito");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cliente no encontrado");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>eliminar(@PathVariable int id){
        boolean eliminado=clienteService.eliminar(id);
        if (eliminado){
            return ResponseEntity.ok("cliente eliminado con éxito");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cliente no encontrado");
        }
    }
}
