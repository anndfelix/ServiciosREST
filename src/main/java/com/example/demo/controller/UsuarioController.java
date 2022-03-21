package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.services.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class UsuarioController {
    UsuarioServices usuarioService;

    public UsuarioController(UsuarioServices usuarioService) {
        this.usuarioService = usuarioService;
    }

  
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllTodos() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
  
    @GetMapping({"/{usuarioId}"})
    public ResponseEntity<Usuario> getTodo(@PathVariable Long Id) {
        return new ResponseEntity<>(usuarioService.getUsuarioById(Id), HttpStatus.OK);
    }
            @PostMapping
    public ResponseEntity<Usuario> saveTodo(@RequestBody Usuario usuario) {
        Usuario usuario1 = usuarioService.insert(usuario);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("todo", "/api/v1/todo/" + usuario1.getId().toString());
        return new ResponseEntity<>(usuario1, httpHeaders, HttpStatus.CREATED);
    }
   
    @PutMapping({"/{usuarioId}"})
    public ResponseEntity<Usuario> updateTodo(@PathVariable("Id") Long Id, @RequestBody Usuario usuario) {
        usuarioService.updateUsuario(Id, usuario);
        return new ResponseEntity<>(usuarioService.getUsuarioById(Id), HttpStatus.OK);
    }
   
    @DeleteMapping({"/{usuarioId}"})
    public ResponseEntity<Usuario> deleteTodo(@PathVariable("Id") Long Id) {
        usuarioService.deleteUsuario(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
