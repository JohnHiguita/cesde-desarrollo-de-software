package com.example.parcial2.repositorios;

import com.example.parcial2.modelos.DetalleCine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetalleCineRepositorio extends JpaRepository<DetalleCine, Long> {

    // Buscar por ciudad
    List<DetalleCine> findByCiudad(String ciudad);

    // Buscar por teléfono
    List<DetalleCine> findByTelefono(String telefono);

    // Buscar por dirección
    List<DetalleCine> findByDireccion(String direccion);
}
