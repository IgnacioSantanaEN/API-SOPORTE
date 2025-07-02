package com.Soporte.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoporteDTO {
    private Integer idUsuario;
    private String descripcion;
    private String tipoTicket;
}
