package org.example.spring.AppTiendaOnlinne;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "detallepedidos")
public class Detallepedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pedidoid", nullable = false)
    private org.example.spring.AppTiendaOnlinne.Pedido pedidoid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productoid", nullable = false)
    private org.example.spring.AppTiendaOnlinne.Producto productoid;

    @NotNull
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @NotNull
    @Column(name = "preciounitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal preciounitario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public org.example.spring.AppTiendaOnlinne.Pedido getPedidoid() {
        return pedidoid;
    }

    public void setPedidoid(org.example.spring.AppTiendaOnlinne.Pedido pedidoid) {
        this.pedidoid = pedidoid;
    }

    public org.example.spring.AppTiendaOnlinne.Producto getProductoid() {
        return productoid;
    }

    public void setProductoid(org.example.spring.AppTiendaOnlinne.Producto productoid) {
        this.productoid = productoid;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(BigDecimal preciounitario) {
        this.preciounitario = preciounitario;
    }

}