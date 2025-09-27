package com.example.parcial2.servicios;

import com.example.parcial2.modelos.Cine;
import com.example.parcial2.repositorios.ICineRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CineServicio {

    private final ICineRepositorio cineRepositorio;

    public CineServicio(ICineRepositorio cineRepositorio) {
        this.cineRepositorio = cineRepositorio;
    }

    public Cine guardarCine(Cine cine) {
        return cineRepositorio.save(cine);
    }
}

