package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.*;
import com.example.demo.repository.*;

import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioServices {
    UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuarios::add);
        return usuarios;
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public Usuario insert(Usuario todo) {
        return usuarioRepository.save(todo);
    }

    @Override
    public void updateUsuario(Long id, Usuario todo) {
        Usuario usuarioFromDb = usuarioRepository.findById(id).get();
        System.out.println(usuarioFromDb.toString());
        usuarioFromDb.setGenero(todo.getGenero());
        usuarioFromDb.setNombre(todo.getNombre());
        usuarioFromDb.setTelefono(todo.getTelefono());
        usuarioRepository.save(usuarioFromDb);
    }

    @Override
    public void deleteUsuario(Long Id) {
        usuarioRepository.deleteById(Id);
    }
}
