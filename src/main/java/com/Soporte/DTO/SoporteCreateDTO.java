package com.Soporte.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoporteCreateDTO {
    private Integer idUsuario;
    private String tipoTicket;
    private String descripcion;
}
