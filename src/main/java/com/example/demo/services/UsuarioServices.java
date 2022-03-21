package com.example.demo.services;
import java.util.List;

import com.example.demo.model.*;

public interface UsuarioServices {
    
    List<Usuario> getUsuarios();

    Usuario getUsuarioById(Long id);

    Usuario insert(Usuario usuario);

    void updateUsuario(Long id, Usuario usuario);

    void deleteUsuario(Long usuarioId);
}
