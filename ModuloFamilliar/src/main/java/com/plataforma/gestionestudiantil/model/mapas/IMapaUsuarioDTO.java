package com.plataforma.gestionestudiantil.model.mapas;

import com.plataforma.gestionestudiantil.model.Usuario;
import com.plataforma.gestionestudiantil.model.dto.UsuarioGenericoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface IMapaUsuarioDTO {

    IMapaUsuarioDTO INSTANCE= Mappers.getMapper(IMapaUsuarioDTO.class);

    //Convirtiendo un modelo en DTO


    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "rol", target = "rol")
    UsuarioGenericoDTO convertirADTO(Usuario usuario);

    List<UsuarioGenericoDTO> convertirListaDTO(List<Usuario> lista);

    List<UsuarioGenericoDTO> convertirADTO(List<Usuario> all);
}
