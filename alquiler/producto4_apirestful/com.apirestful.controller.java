package com.example.apirestful.controller;

import com.example.apirestful.model.Alquiler;
import com.example.apirestful.model.Cliente;
import com.example.apirestful.service.AlquilerService;
import com.example.apirestful.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private AlquilerService alquilerService;

    @Autowired
    private ClienteService clienteService;

    // Ruta GET para listar todos los alquileres
    @GetMapping("/alquilerVehiculos")
    public List<Alquiler> getAlquileres() {
        return alquilerService.getAllAlquileres();
    }

    // Ruta GET para listar todos los clientes
    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clienteService.getAllClientes();
    }
}
