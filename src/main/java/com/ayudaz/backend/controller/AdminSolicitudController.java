package com.ayudaz.backend.controller;

import com.ayudaz.backend.model.SolicitudAyuda;
import com.ayudaz.backend.repository.SolicitudAyudaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/solicitudes")
@CrossOrigin("*")
public class AdminSolicitudController {

    @Autowired
    private SolicitudAyudaRepository solicitudRepository;

    // =========================
    // LISTAR SOLICITUDES
    // =========================

    @GetMapping
    public List<SolicitudAyuda> obtenerSolicitudes() {

        return solicitudRepository.findAll();
    }

    // =========================
    // ELIMINAR
    // =========================

    @DeleteMapping("/{id}")
    public void eliminarSolicitud(
            @PathVariable Long id
    ) {

        solicitudRepository.deleteById(id);
    }
}