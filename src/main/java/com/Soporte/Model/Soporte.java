package com.Soporte.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "soporte")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Soporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ticket;
    private Integer id_usuario;
    private String tipo_ticket;
    private String descripcion;
    private String estado;
    private LocalDate fecha_creacion;
    private LocalDate fecha_resolucion;
}
