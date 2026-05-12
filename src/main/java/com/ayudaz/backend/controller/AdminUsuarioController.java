package com.ayudaz.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.ayudaz.backend.repository.UsuarioRepository;

import com.ayudaz.backend.model.Usuario;

@RestController
@RequestMapping("/api/admin/usuarios")
@CrossOrigin("*")
public class AdminUsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // =========================
    // LISTAR USUARIOS
    // =========================

    @GetMapping
    public List<Usuario> obtenerUsuarios() {

        return usuarioRepository.findAll();
    }

    // =========================
    // ELIMINAR USUARIO
    // =========================

    @DeleteMapping("/{id}")
    public void eliminarUsuario(
            @PathVariable Long id
    ) {

        usuarioRepository.deleteById(id);
    }
}