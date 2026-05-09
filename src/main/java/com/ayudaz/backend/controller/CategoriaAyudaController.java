package com.ayudaz.backend.controller;

import com.ayudaz.backend.model.CategoriaAyuda;
import com.ayudaz.backend.repository.CategoriaAyudaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class CategoriaAyudaController {
    private final CategoriaAyudaRepository repo;

    @GetMapping
    public List<CategoriaAyuda> listar() { return repo.findAll(); }

    @PostMapping
    public CategoriaAyuda crear(@RequestBody CategoriaAyuda c) { return repo.save(c); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { repo.deleteById(id); }
}