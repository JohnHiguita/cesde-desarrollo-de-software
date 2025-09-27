package com.plataforma.gestionestudiantil.service;

import com.plataforma.gestionestudiantil.model.Usuario;
import com.plataforma.gestionestudiantil.model.dto.UsuarioGenericoDTO;
import com.plataforma.gestionestudiantil.model.mapas.IMapaUsuarioDTO;
import com.plataforma.gestionestudiantil.repository.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    //1. Llamar al repositorio
    //INYECTAR UNA DEPENDENCIA AL REPO
    @Autowired
    IUsuarioRepositorio repositorio;

    @Autowired
    IMapaUsuarioDTO mapa;

    //1. Servicio para guardar un usuario
    public UsuarioGenericoDTO guardarUsuario(Usuario datosUsuario)throws Exception{
        try{
            return this.mapa.convertirADTO(this.repositorio.save(datosUsuario));

        }catch(Exception error){
            throw new Exception("upss fallamos "+error.getMessage());
        }
    }

    //2. servicios para buscar todos los usuarios
    public List<UsuarioGenericoDTO> buscarUsuarios()throws Exception{
        try {
            return this.mapa.convertirADTO(this.repositorio.findAll());
        }catch (Exception error){
            throw  new Exception("upps fallamos" +error.getMessage());
        }
    }

    //3. Servicio para buscar un usuario si me dan su ID
    public UsuarioGenericoDTO buscarUsuarioPorID(Integer id)throws  Exception {
        try {
            Optional<Usuario> UsuarioBuscado = this.repositorio.findById(id);
            if (UsuarioBuscado.isPresent()) { //SI SI ESTA
                return this.mapa.convertirADTO(UsuarioBuscado.get());
            } else { // SINO ESTA
                throw new Exception("Usuario no encontrado");

            }
        } catch (Exception error) {
            throw new Exception("upps fallamos" + error.getMessage());
        }
    }
}

