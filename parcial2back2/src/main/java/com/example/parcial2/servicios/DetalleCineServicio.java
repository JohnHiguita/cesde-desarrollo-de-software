package com.example.parcial2.servicios;

import com.example.parcial2.modelos.DetalleCine;
import com.example.parcial2.repositorios.IDetalleCineRepositorio;
import org.springframework.stereotype.Service;

@Service
public class DetalleCineServicio {

    private final IDetalleCineRepositorio detalleCineRepositorio;

    public DetalleCineServicio(IDetalleCineRepositorio detalleCineRepositorio) {
        this.detalleCineRepositorio = detalleCineRepositorio;
    }

    public DetalleCine guardarDetalle(DetalleCine detalleCine) {
        return detalleCineRepositorio.save(detalleCine);
    }

}
