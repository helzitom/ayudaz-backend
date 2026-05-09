package com.ayudaz.backend.controller;

import com.ayudaz.backend.model.Voluntario;
import com.ayudaz.backend.service.VoluntarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/voluntarios")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class VoluntarioController {
    private final VoluntarioService service;

    @GetMapping
    public List<Voluntario> listar() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public ResponseEntity<Voluntario> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Voluntario> porUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(service.buscarPorUsuario(idUsuario));
    }

    @PostMapping
    public ResponseEntity<Voluntario> crear(@RequestBody Voluntario v) {
        return ResponseEntity.ok(service.guardar(v));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Voluntario> actualizar(@PathVariable Long id, @RequestBody Voluntario datos) {
        return ResponseEntity.ok(service.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}