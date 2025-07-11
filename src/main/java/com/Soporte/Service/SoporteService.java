package com.Soporte.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Soporte.DTO.SoporteDTO;
import com.Soporte.Model.Soporte;
import com.Soporte.Repository.SoporteRepository;

@Service
public class SoporteService {
    private final SoporteRepository repository;

    public SoporteService(SoporteRepository soporteRepository){
        this.repository = soporteRepository;
    }

    public List<SoporteDTO> findAll(){
        return repository.findAll().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    public Soporte findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
    
    public Soporte save(Soporte soporte) {
        return repository.save(soporte);
    }

    public boolean deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Soporte update(Soporte soporte) {
        return repository.save(soporte);
    }
    
    public SoporteDTO toDTO(Soporte soporte) {
        if (soporte == null) return null;

        return new SoporteDTO(
            soporte.getIdTicket(),
            "http://localhost:8083/api/soporte/" + soporte.getIdTicket()
        );
    }
}
