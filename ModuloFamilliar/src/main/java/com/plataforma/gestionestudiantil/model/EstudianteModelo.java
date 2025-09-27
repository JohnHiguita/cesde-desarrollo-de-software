package com.plataforma.gestionestudiantil.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class EstudianteModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "estudiante", length = 50, nullable = false, unique = false)
    private String nombre;

    //Constructor vacío

    @OneToMany(mappedBy = "notasModelo")
    @JsonManagedReference(value = "relacionesestudiantenotas")
    private ArrayList<NotasModelo> notasModelos;
    public EstudianteModelo() {
    }

    //Constructor con parámetros
    public EstudianteModelo(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    //Getters & Setters


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
}
