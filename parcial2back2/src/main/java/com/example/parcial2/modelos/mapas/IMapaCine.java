package com.example.parcial2.modelos.mapas;

import com.example.parcial2.modelos.Cine;
import com.example.parcial2.modelos.dtos.CineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaCine {

    // Conversión de Modelo -> DTO
    @Mapping(source = "detalle", target = "detalleCine") // porque en la entidad se llama detalle
    CineDTO convertirModeloADto(Cine cine);

    // Conversión de DTO -> Modelo
    @Mapping(source = "detalleCine", target = "detalle")
    Cine convertirDtoAModelo(CineDTO cineDTO);

    // Conversión de listas
    List<CineDTO> convertirListaADto(List<Cine> cines);
    List<Cine> convertirListaAModelo(List<CineDTO> cineDtos);
}
