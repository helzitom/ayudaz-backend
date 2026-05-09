package com.ayudaz.backend.controller;

import com.ayudaz.backend.model.SolicitudAyuda;
import com.ayudaz.backend.service.SolicitudAyudaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class SolicitudAyudaController {
    private final SolicitudAyudaService service;

    @GetMapping
    public List<SolicitudAyuda> listar() { return service.listarTodas(); }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudAyuda> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<SolicitudAyuda> porUsuario(@PathVariable Long idUsuario) {
        return service.listarPorUsuario(idUsuario);
    }

    @GetMapping("/categoria/{idCategoria}")
    public List<SolicitudAyuda> porCategoria(@PathVariable Long idCategoria) {
        return service.listarPorCategoria(idCategoria);
    }

    @GetMapping("/estado/{estado}")
    public List<SolicitudAyuda> porEstado(@PathVariable String estado) {
        return service.listarPorEstado(estado);
    }

    @PostMapping
    public ResponseEntity<SolicitudAyuda> crear(@RequestBody SolicitudAyuda s) {
        return ResponseEntity.ok(service.guardar(s));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudAyuda> actualizar(@PathVariable Long id, @RequestBody SolicitudAyuda datos) {
        return ResponseEntity.ok(service.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}