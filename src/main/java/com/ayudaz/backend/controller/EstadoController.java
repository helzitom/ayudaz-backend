package com.ayudaz.backend.controller;

import com.ayudaz.backend.model.Estado;
import com.ayudaz.backend.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estados")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class EstadoController {
    private final EstadoRepository repo;

    @GetMapping
    public List<Estado> listar() { return repo.findAll(); }

    @GetMapping("/tabla/{tipoTabla}")
    public List<Estado> porTabla(@PathVariable String tipoTabla) {
        return repo.findByTipoTabla(tipoTabla);
    }

    @PostMapping
    public Estado crear(@RequestBody Estado e) { return repo.save(e); }
}