package com.example.parcial2.modelos.mapas;

import com.example.parcial2.modelos.Cine;
import com.example.parcial2.modelos.Sala;
import com.example.parcial2.modelos.dtos.CineDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-26T23:57:35-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class IMapaCineImpl implements IMapaCine {

    @Override
    public CineDTO convertirModeloADto(Cine cine) {
        if ( cine == null ) {
            return null;
        }

        CineDTO cineDTO = new CineDTO();

        cineDTO.setDetalleCine( cine.getDetalle() );
        cineDTO.setId( cine.getId() );
        cineDTO.setNombre( cine.getNombre() );
        cineDTO.setNit( cine.getNit() );
        List<Sala> list = cine.getSalas();
        if ( list != null ) {
            cineDTO.setSalas( new ArrayList<Sala>( list ) );
        }

        return cineDTO;
    }

    @Override
    public Cine convertirDtoAModelo(CineDTO cineDTO) {
        if ( cineDTO == null ) {
            return null;
        }

        Cine cine = new Cine();

        cine.setDetalle( cineDTO.getDetalleCine() );
        cine.setId( cineDTO.getId() );
        cine.setNombre( cineDTO.getNombre() );
        cine.setNit( cineDTO.getNit() );
        List<Sala> list = cineDTO.getSalas();
        if ( list != null ) {
            cine.setSalas( new ArrayList<Sala>( list ) );
        }

        return cine;
    }

    @Override
    public List<CineDTO> convertirListaADto(List<Cine> cines) {
        if ( cines == null ) {
            return null;
        }

        List<CineDTO> list = new ArrayList<CineDTO>( cines.size() );
        for ( Cine cine : cines ) {
            list.add( convertirModeloADto( cine ) );
        }

        return list;
    }

    @Override
    public List<Cine> convertirListaAModelo(List<CineDTO> cineDtos) {
        if ( cineDtos == null ) {
            return null;
        }

        List<Cine> list = new ArrayList<Cine>( cineDtos.size() );
        for ( CineDTO cineDTO : cineDtos ) {
            list.add( convertirDtoAModelo( cineDTO ) );
        }

        return list;
    }
}
