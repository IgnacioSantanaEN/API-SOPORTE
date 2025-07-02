package com.Soporte.Mapper;

import com.Soporte.DTO.SoporteDTO;
import com.Soporte.Model.Soporte;

public class SoporteMapper {
    public static SoporteDTO toDTO(Soporte soporte) {
        if (soporte == null) return null;

        return new SoporteDTO(
            soporte.getIdUsuario(),
            soporte.getDescripcion(),
            soporte.getTipoTicket()
        );
    }

    public static Soporte toEntity(SoporteDTO dto) {
        if (dto == null) return null;

        Soporte soporte = new Soporte();
        soporte.setIdUsuario(dto.getIdUsuario());
        soporte.setDescripcion(dto.getDescripcion());
        soporte.setTipoTicket(dto.getTipoTicket());
        return soporte;
    }
}
