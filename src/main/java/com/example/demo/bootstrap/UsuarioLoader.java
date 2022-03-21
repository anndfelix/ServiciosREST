package com.example.demo.bootstrap;

import com.example.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UsuarioLoader implements CommandLineRunner {
    public final UsuarioRepository usuarioRepository;

    public UsuarioLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
    }
 
}