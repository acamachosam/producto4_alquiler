package com.alquilercoches.coches.controllers;

import com.alquilercoches.coches.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class RegistroController {

    @Autowired
    private UserService userService;

    // Mostrar formulario de registro
    @GetMapping("/registro")
    public String mostrarFormularioRegistro() {
        return "registro";  // El archivo HTML que contiene el formulario de registro
    }

    // Procesar el registro de usuario
    @PostMapping("/registro")
    public String procesarRegistro(@RequestParam String username, @RequestParam String password, @RequestParam String roles, Model model) {
        try {
            // Registrar el usuario
            userService.registrarUsuario(username, password, roles);

            // Redirigir al login con un mensaje de éxito
            model.addAttribute("mensaje", "Usuario registrado con éxito. Inicia sesión ahora.");
            return "redirect:/login";  // Redirigir a la página de login
        } catch (Exception e) {
            // En caso de error, mostrar un mensaje de error
            model.addAttribute("error", e.getMessage());
            return "registro";  // Regresar al formulario de registro en caso de error
        }
    }
}
