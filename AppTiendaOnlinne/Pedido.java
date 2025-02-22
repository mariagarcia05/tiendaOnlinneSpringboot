package org.example.spring.AppTiendaOnlinne;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull(message = "el id del cliente no puede estar vacío")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "clienteid", nullable = false)
    private Cliente clienteid;

    @NotNull(message = "la fecha no puede estar vacía")
    @ColumnDefault("current_timestamp()")
    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @NotNull(message = "el total no puede estar vacío")
    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    public Pedido() {
    }

    public Pedido(Integer id, Cliente clienteid, Instant fecha, BigDecimal total) {
        this.id = id;
        this.clienteid = clienteid;
        this.fecha = fecha;
        this.total = total;
    }

    public Pedido(Cliente clienteid, Instant fecha, BigDecimal total) {
        this.clienteid = clienteid;
        this.fecha = fecha;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getClienteid() {
        return clienteid;
    }

    public void setClienteid(Cliente clienteid) {
        this.clienteid = clienteid;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }


}