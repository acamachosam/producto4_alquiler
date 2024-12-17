package com.example.apirestful.service;

import com.example.apirestful.model.Alquiler;
import com.example.apirestful.repository.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlquilerService {

    @Autowired
    private AlquilerRepository alquilerRepository;

    public List<Alquiler> getAllAlquileres() {
        return alquilerRepository.findAll();
    }
}
