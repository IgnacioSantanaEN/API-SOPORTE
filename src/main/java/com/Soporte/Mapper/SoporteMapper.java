package com.Soporte.Mapper;

import com.Soporte.DTO.SoporteDTO;
import com.Soporte.Model.Soporte;

public class SoporteMapper {
    public static SoporteDTO toDTO(Soporte soporte) {
        if (soporte == null) return null;

        return new SoporteDTO(
            soporte.getIdTicket(),
            "http://localhost:8083/api/soporte/" + soporte.getIdTicket()
        );
    }

    public static Soporte toEntity(SoporteDTO dto) {
        if (dto == null) return null;

        Soporte soporte = new Soporte();
        soporte.setIdTicket(dto.getIdTicket());
        return soporte;
    }
}
