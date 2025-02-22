package org.example.spring.AppTiendaOnlinne;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "el nombre no puede estar vacio")
    @Size(max = 100, message = "no puede tener mas de 100 caracteres")
    @NotNull
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "la descripcion no puede estar vacia")
    @NotNull
    @Lob
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @NotNull(message = "el precio no puede estar vacío")
    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;


    @NotNull(message = "el stock no puede estar vacio")
    @Column(name = "stock", nullable = false)
    private Integer stock;

    @NotNull(message = "la categoriaid no puede estar vacia")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "categoriaid", nullable = false)
    private Categoria categoriaid;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, BigDecimal precio, Integer stock, Categoria categoriaid) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoriaid = categoriaid;
    }

    public Producto(Integer id, String nombre, String descripcion, BigDecimal precio, Integer stock, Categoria categoriaid) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoriaid = categoriaid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Categoria getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(Categoria categoriaid) {
        this.categoriaid = categoriaid;
    }


}