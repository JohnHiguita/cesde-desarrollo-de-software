package com.example.parcial2.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.util.List;

@Entity
@Table(name = "cines")
public class Cine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 250, nullable = false,  unique = true)
    private String nombre;

    @Column(name = "nit", length = 250, nullable = false,  unique = true)
    private String nit;

    @OneToOne(mappedBy = "cine")
    private DetalleCine detalle;

    @OneToMany(mappedBy = "cine")
    @JsonManagedReference(value = "relacionsalacine")
    private List<Sala> salas;

    public Cine() {
    }

    public Cine(String nombre, String nit, DetalleCine detalle, java.util.List<Sala> salas) {
        this.nombre = nombre;
        this.nit = nit;
        this.detalle = detalle;
        this.salas = salas;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public DetalleCine getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleCine detalle) {
        this.detalle = detalle;
    }

    public java.util.List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(java.util.List<Sala> salas) {
        this.salas = salas;
    }
}