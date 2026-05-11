package com.ayudaz.backend.controller;

import com.ayudaz.backend.dto.RegistroRequest;
import com.ayudaz.backend.model.Usuario;
import com.ayudaz.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public List<Usuario> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<Usuario> buscarPorCorreo(@PathVariable String correo) {

        return service.buscarPorCorreoOpcional(correo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody RegistroRequest req) {

        Usuario usuario = new Usuario();

        usuario.setNombres(req.getNombres());
        usuario.setCorreo(req.getCorreo());
        usuario.setTelefono(req.getTelefono());
        usuario.setDireccion(req.getDireccion());

        Usuario creado = service.guardar(usuario, req.getRol());

        return ResponseEntity.ok(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(
            @PathVariable Long id,
            @RequestBody Usuario datos
    ) {

        return ResponseEntity.ok(
                service.actualizar(id, datos)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}