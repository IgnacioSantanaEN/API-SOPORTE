package com.Soporte.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.Soporte.Model.Soporte;
import com.Soporte.Service.SoporteService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private final SoporteService soporteService;

    public SoporteController(SoporteService soporteService) {
        this.soporteService = soporteService;
    }

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
            return ResponseEntity.status(404).body(new Mensaje("Ticket no encontrado: " + id));
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Soporte soporte) {
        try {
            Soporte nuevo = soporteService.save(soporte);
            return ResponseEntity.status(201).body(nuevo);
        } catch (Exception error) {
            return ResponseEntity.status(400).body(new Mensaje("Error al crear el ticket."));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Soporte soporte) {
            Soporte existente = soporteService.findById(id);

        if (existente != null) {
            soporte.setId_ticket(id); // asegura que actualiza el correcto
            Soporte actualizado = soporteService.update(soporte);
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.status(404).body(new Mensaje("Ticket no encontrado: " + id));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (soporteService.deleteById(id)) {
            return ResponseEntity.ok("Ticket eliminado con éxito");
        }
        return ResponseEntity.status(404).body("Ticket no encontrado: " + id);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Mensaje {
        private String mensaje;
    }
}
