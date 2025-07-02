package com.Soporte.DTO;

import java.time.LocalDate;
import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoporteModel extends RepresentationModel<SoporteModel> {
    private Integer idTicket;
    private Integer idUsuario;
    private String tipoTicket;
    private String descripcion;
    private String estado;
    private LocalDate fechaCreacion;
    private LocalDate fechaResolucion;
    private String link;
}
