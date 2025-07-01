package com.Soporte.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Soporte.Model.Soporte;

@Repository
public interface SoporteRepository extends JpaRepository <Soporte, Integer>{
    
}
