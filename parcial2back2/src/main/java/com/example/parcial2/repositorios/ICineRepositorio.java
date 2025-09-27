package com.example.parcial2.repositorios;

import com.example.parcial2.modelos.Cine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICineRepositorio extends JpaRepository<Cine, Long> {
    Optional<Cine> findByNit(String nit);
}

