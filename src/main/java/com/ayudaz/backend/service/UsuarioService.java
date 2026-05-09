package com.ayudaz.backend.service;

import com.ayudaz.backend.model.Usuario;
import com.ayudaz.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repo;

    public List<Usuario> listarTodos() { return repo.findAll(); }

    public Usuario buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario buscarPorCorreo(String correo) {
        return repo.findByCorreo(correo).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario guardar(Usuario usuario) {
        if (repo.existsByCorreo(usuario.getCorreo()))
            throw new RuntimeException("El correo ya está registrado");
        return repo.save(usuario);
    }

    public Usuario actualizar(Long id, Usuario datos) {
        Usuario u = buscarPorId(id);
        u.setNombres(datos.getNombres());
        u.setTelefono(datos.getTelefono());
        u.setDireccion(datos.getDireccion());
        return repo.save(u);
    }

    public void eliminar(Long id) { repo.deleteById(id); }
}