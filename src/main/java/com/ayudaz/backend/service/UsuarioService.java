package com.ayudaz.backend.service;

import com.ayudaz.backend.model.*;
import com.ayudaz.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepo;
    private final RolRepository rolRepo;
    private final UsuarioRolRepository usuarioRolRepo;
    private final VoluntarioRepository voluntarioRepo;

    public List<Usuario> listarTodos() {
        return usuarioRepo.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario buscarPorCorreo(String correo) {
        return usuarioRepo.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Optional<Usuario> buscarPorCorreoOpcional(String correo) {
        return usuarioRepo.findByCorreo(correo);
    }

    public Usuario guardar(Usuario usuario, String nombreRol) {

        if (usuarioRepo.existsByCorreo(usuario.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        // Guardar usuario
        Usuario nuevoUsuario = usuarioRepo.save(usuario);

        // Buscar rol
        Rol rol = rolRepo.findByNombreRol(nombreRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        // Crear relación usuario_rol
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(nuevoUsuario);
        usuarioRol.setRol(rol);

        usuarioRolRepo.save(usuarioRol);

        // Si es voluntario
        if (nombreRol.equals("VOLUNTARIO")) {

            Voluntario voluntario = new Voluntario();
            voluntario.setUsuario(nuevoUsuario);

            voluntarioRepo.save(voluntario);
        }

        return nuevoUsuario;
    }

    public Usuario actualizar(Long id, Usuario datos) {

        Usuario u = buscarPorId(id);

        u.setNombres(datos.getNombres());
        u.setTelefono(datos.getTelefono());
        u.setDireccion(datos.getDireccion());

        return usuarioRepo.save(u);
    }

    public void eliminar(Long id) {
        usuarioRepo.deleteById(id);
    }
}