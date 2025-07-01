package com.Soporte.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Soporte.Model.Soporte;
import com.Soporte.Repository.SoporteRepository;

@Service
public class SoporteService {
    private final SoporteRepository soporteRepository;

    public SoporteService(SoporteRepository soporteRepository){
        this.soporteRepository = soporteRepository;
    }

    public List<Soporte> findAll(){
        return soporteRepository.findAll();
    }

    public Soporte findById(Integer id) {
        return soporteRepository.findById(id).orElse(null);
    }
    
    public Soporte save(Soporte soporte) {
        return soporteRepository.save(soporte);
    }

    public boolean deleteById(Integer id) {
        if (soporteRepository.existsById(id)) {
            soporteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Soporte update(Soporte soporte) {
        return soporteRepository.save(soporte);
    }
    
}
