package com.Soporte.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.Soporte.DTO.SoporteCreateDTO;
import com.Soporte.DTO.SoporteDTO;
import com.Soporte.Model.Soporte;
import com.Soporte.Service.SoporteService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/soporte")
public class SoporteController {
    @Autowired
    private SoporteService soporteService;

    @GetMapping("/")
    public ResponseEntity<List<Soporte>> getAll() {
        return ResponseEntity.ok(soporteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Soporte soporte = soporteService.findById(id);
    
        if (soporte != null) {
            return ResponseEntity.ok(soporte);
        } else {
            return ResponseEntity.status(404)
            .body(new Mensaje("Ticket no encontrado: " + id));
        }
    }

    @GetMapping("/Resumen")
    public ResponseEntity<?> getTicketCliente(){
        List<SoporteDTO> soporteDTOs = soporteService.findAll().stream()
        .map(s -> new SoporteDTO(s.getIdUsuario(), s.getDescripcion(), s.getTipoTicket()))
        .toList();

        return ResponseEntity.ok(soporteDTOs);
    }
    
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Soporte soporte) {
        Soporte nuevo = soporteService.save(soporte);
        if(nuevo == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Mensaje("No se ha podido crear la solicitud"));
        }

        return ResponseEntity.status(HttpStatus.CREATED)
        .body(new Mensaje("Recurso creado con exito: " + nuevo.getIdTicket()));
    }

    @PostMapping("/cliente")
    public ResponseEntity<?> createCliente(@RequestBody SoporteCreateDTO dto){
        Soporte soporte = new Soporte();
        soporte.setIdUsuario(dto.getIdUsuario());
        soporte.setTipoTicket(dto.getTipoTicket());
        soporte.setDescripcion(dto.getDescripcion());
        soporte.setEstado("Abierto");
        soporte.setFechaCreacion(LocalDate.now());

        Soporte nuevo = soporteService.save(soporte);

        if (nuevo == null) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(new Mensaje("No se ha podido crear el ticket"));
    }

    return ResponseEntity.status(HttpStatus.CREATED)
                         .body(new Mensaje("Ticket creado con éxito: " + nuevo.getIdTicket()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Soporte soporte) {
        Soporte existente = soporteService.findById(id);

        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new Mensaje("Recurso no encontrado: " + id));
        }    
        
        existente.setTipoTicket(soporte.getTipoTicket());
        existente.setDescripcion(soporte.getDescripcion());
        existente.setEstado(soporte.getEstado());
        existente.setFechaCreacion(soporte.getFechaCreacion());
        existente.setFechaResolucion(soporte.getFechaResolucion());

        soporteService.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (soporteService.deleteById(id)) {
            return ResponseEntity.ok("Ticket eliminado con éxito");
        }
        return ResponseEntity.status(404)
        .body(new Mensaje("Recurso no encontrado: "+id));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Mensaje {
        private String mensaje;
    }
}
