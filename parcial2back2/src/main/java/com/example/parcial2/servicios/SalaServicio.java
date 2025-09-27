package com.example.parcial2.servicios;

import com.example.parcial2.modelos.Sala;
import com.example.parcial2.repositorios.ISalaRepositorio;
import org.springframework.stereotype.Service;

@Service
public class SalaServicio {

    private final ISalaRepositorio salaRepositorio;

    public SalaServicio(ISalaRepositorio salaRepositorio) {
        this.salaRepositorio = salaRepositorio;
    }

    public Sala guardarSala(Sala sala) {
        return salaRepositorio.save(sala);
    }

}
