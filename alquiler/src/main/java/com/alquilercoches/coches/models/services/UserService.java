package com.alquilercoches.coches.models.services;


import org.springframework.stereotype.Service;
import com.alquilercoches.coches.models.entities.Usuario;
import com.alquilercoches.coches.models.dao.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.alquilercoches.coches.config.SecurityConfig;



@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private SecurityConfig securityConfig;

    public void registrarUsuario(String username, String password, String roles) {
        Usuario user = new Usuario();
        user.setUsername(username);
        user.setPassword(password); // Codificar la contraseña
        user.setRoles(roles);

        usuarioRepository.save(user); // Guardar el usuario en la base de datos
        System.out.println("Usuario registrado con éxito: " + username);
    }


}
