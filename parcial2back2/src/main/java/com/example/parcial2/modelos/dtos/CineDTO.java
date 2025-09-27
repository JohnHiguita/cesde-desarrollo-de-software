package com.example.parcial2.modelos.dtos;

import com.example.parcial2.modelos.DetalleCine;
import com.example.parcial2.modelos.Sala;

import java.util.List;

public class CineDTO {
    private Long id;
    private String nombre;
    private String nit;
    private DetalleCine detalleCine;
    private List<Sala> salas;

    public CineDTO() {
    }

    public CineDTO(String nombre, String nit, DetalleCine detalleCine, List<Sala> salas) {
        this.nombre = nombre;
        this.nit = nit;
        this.detalleCine = detalleCine;
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

    public DetalleCine getDetalleCine() {
        return detalleCine;
    }

    public void setDetalleCine(DetalleCine detalleCine) {
        this.detalleCine = detalleCine;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
}
