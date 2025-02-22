package org.example.spring.AppTiendaOnlinne;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "el nombre no puede estar vacio")
    @Size(max = 100, message = "no puede tener mas de 100 caracteres")
    @NotNull
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "el email no puede estar vacio")
    @Size(max = 100, message = "no puede tener mas de 100 caracteres")
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @NotBlank(message = "el telefono no puede estar vacio")
    @Size(max = 15, message = "no puede tener mas de 15 caracteres")
    @Column(name = "telefono", length = 15)
    private String telefono;

    @NotBlank(message = "la dirección no puede estar vacia")
    @Lob
    @Column(name = "direccion")
    private String direccion;

    public Cliente() {
    }

    public Cliente(Integer id, String nombre, String email, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente(String nombre, String email, String telefono, String direccion) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}