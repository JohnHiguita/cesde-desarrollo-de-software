package com.plataforma.gestionestudiantil.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "materia", length = 50, nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_notas") // por defecto referencia a la PK (id) de NotasModelo
    @JsonBackReference(value = "relacionnotasmateria")
    private NotasModelo notasModelo;

    public Materia() {}

    public Materia(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public NotasModelo getNotasModelo() { return notasModelo; }
    public void setNotasModelo(NotasModelo notasModelo) { this.notasModelo = notasModelo; }
}
