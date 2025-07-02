package com.Soporte.Mapper;

import com.Soporte.Model.Soporte;
import com.Soporte.DTO.SoporteModel;

public class SoporteHateoasMapper {

    public static SoporteModel toModel(Soporte soporte) {
        SoporteModel model = new SoporteModel();

        model.setIdTicket(soporte.getIdTicket());
        model.setIdUsuario(soporte.getIdUsuario());
        model.setTipoTicket(soporte.getTipoTicket());
        model.setDescripcion(soporte.getDescripcion());
        model.setEstado(soporte.getEstado());
        model.setFechaCreacion(soporte.getFechaCreacion());
        model.setFechaResolucion(soporte.getFechaResolucion());

        model.setLink("http://localhost:8085/api/soporte/" + soporte.getIdTicket());

        return model;
    }
}
