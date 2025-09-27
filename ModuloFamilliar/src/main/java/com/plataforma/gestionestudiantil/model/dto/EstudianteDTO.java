package com.plataforma.gestionestudiantil.model.dto;

public class EstudianteDTO {
    private Integer id;
    private String nombre;

    //Constructor vacío

    public EstudianteDTO() {
    }

    //Constructor con parámetros

    public EstudianteDTO(Integer id, String nombre) {
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
