package org.example.spring.AppTiendaOnlinne.Service;

import org.example.spring.AppTiendaOnlinne.Pedido;
import org.example.spring.AppTiendaOnlinne.Respository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> obtenerTodos(){
        return pedidoRepository.findAll();
    }
    public Optional<Pedido>obtenerPorId(int id){
        return pedidoRepository.findById(id);
    }
    public Pedido guardar(Pedido pedido){
       return pedidoRepository.save(pedido);
    }
    public boolean actualizar(Pedido nuevoPedido){
        Optional<Pedido>pedidoExistente=pedidoRepository.findById(nuevoPedido.getId());
        if (pedidoExistente.isPresent()){
            pedidoRepository.save(nuevoPedido);
            return true;
        }
        return false;
    }
    public boolean eliminar(int id){
        if (pedidoRepository.existsById(id)){
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
