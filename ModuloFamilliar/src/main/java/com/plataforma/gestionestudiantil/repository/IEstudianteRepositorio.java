package com.plataforma.gestionestudiantil.repository;

import com.plataforma.gestionestudiantil.model.EstudianteModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEstudianteRepositorio extends JpaRepository<EstudianteModelo, Integer> {
    List<EstudianteModelo> findByNota(Float nota);
}
