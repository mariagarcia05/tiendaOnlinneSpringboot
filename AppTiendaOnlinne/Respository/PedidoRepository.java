package org.example.spring.AppTiendaOnlinne.Respository;

import org.example.spring.AppTiendaOnlinne.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
}
