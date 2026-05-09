package com.ayudaz.backend.controller;

import com.ayudaz.backend.model.Donacion;
import com.ayudaz.backend.service.DonacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/donaciones")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class DonacionController {
    private final DonacionService service;

    @GetMapping
    public List<Donacion> listar() { return service.listarTodas(); }

    @GetMapping("/{id}")
    public ResponseEntity<Donacion> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/usuario/{id}")
    public List<Donacion> porUsuario(@PathVariable Long id) {
        return service.listarPorUsuario(id);
    }

    @GetMapping("/solicitud/{id}")
    public List<Donacion> porSolicitud(@PathVariable Long id) {
        return service.listarPorSolicitud(id);
    }

    @PostMapping
    public ResponseEntity<Donacion> crear(@RequestBody Donacion d) {
        return ResponseEntity.ok(service.guardar(d));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}