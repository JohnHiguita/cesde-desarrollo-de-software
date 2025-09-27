package com.example.parcial2.modelos;

import com.example.parcial2.ayudas.tipoSala;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
@Table(name = "salas")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 250, nullable = false, unique = true)
    private String nombre;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    @Column(name = "tipo", length = 250, nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private tipoSala tipo; // 2D, 3D, IMAX...

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonBackReference(value = "relacionsalacine")
    @JoinColumn(name = "cine_id", nullable = false)  // sin unique = true
    private Cine cine;


    public Sala() {
    }

    public Sala(String nombre, Integer capacidad, tipoSala tipo, Cine cine) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.cine = cine;
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

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public tipoSala getTipo() {
        return tipo;
    }

    public void setTipo(tipoSala tipo) {
        this.tipo = tipo;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }
}
