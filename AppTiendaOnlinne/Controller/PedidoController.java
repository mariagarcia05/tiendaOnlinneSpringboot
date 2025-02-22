package org.example.spring.AppTiendaOnlinne.Controller;

import jakarta.validation.Valid;
import org.example.spring.AppTiendaOnlinne.Pedido;
import org.example.spring.AppTiendaOnlinne.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
@CacheConfig(cacheNames = {"pedido"})
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>>obtenerTodos(){
        List<Pedido>pedidos=pedidoService.obtenerTodos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Optional<Pedido>>obtenerPorId(@PathVariable int id){
        try {
            Thread.sleep(3000);
            Optional<Pedido>pedido=pedidoService.obtenerPorId(id);
            return new ResponseEntity<>(pedido,HttpStatus.OK);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    @PostMapping
    public ResponseEntity<String>guardar(@RequestBody @Valid Pedido pedido){
        try {
            Pedido pedidoGuardar=pedidoService.guardar(pedido);
            return ResponseEntity.ok("pedido añadido con exito");
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno al guardar el pedido");
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<String>actualizar(@RequestBody Pedido nuevoPedido){
        boolean actualizado= pedidoService.actualizar(nuevoPedido);
        if (actualizado){
            return ResponseEntity.ok("pedido actualizado con éxito");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pedido no actualizado");
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String>eliminar(@PathVariable int id){
        boolean eliminado= pedidoService.eliminar(id);
        if (eliminado){
            return ResponseEntity.ok("pedido eliminado con éxito");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pedido no eliminado");
        }
    }


}
