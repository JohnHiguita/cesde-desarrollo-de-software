package com.plataforma.gestionestudiantil.model.mapas;


import com.plataforma.gestionestudiantil.model.EstudianteModelo;
import com.plataforma.gestionestudiantil.model.dto.EstudianteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "Spring")
public interface IMapaEstudianteDTO {
    //Mapear un modelo DTO
    @Mapping(source = "usuario.nombre", target = "nombre")
    @Mapping(source = "usuario.contraseña", target = "contraseña")
    @Mapping(source = "usuario.rol", target = "rol")
    @Mapping(source = "promedio", target = "promedio")
    @Mapping(source = "usuario.fechaNacimiento", target = "fechaNacimiento")
    EstudianteDTO convertir_modelo_a_DTO(EstudianteModelo estudiante);

    List<EstudianteDTO> convertir_lista_a_DTO(List<EstudianteModelo> lista);
}
