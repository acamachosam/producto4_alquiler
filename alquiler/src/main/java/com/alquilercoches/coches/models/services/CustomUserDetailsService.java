package com.alquilercoches.coches.models.services;

import com.alquilercoches.coches.models.entities.Usuario;
import com.alquilercoches.coches.models.dao.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .build();
    }



    // Método para registrar nuevos usuarios
    public void registrarUsuario(String username, String password, String roles) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsername(username);
        nuevoUsuario.setPassword(passwordEncoder.encode(password)); // Cifrar la contraseña
        nuevoUsuario.setRoles(roles); // Asignar roles como texto plano o separado por comas

        usuarioRepository.save(nuevoUsuario);
    }
}
