package com.ayudaz.backend.service;

import com.ayudaz.backend.model.Donacion;
import com.ayudaz.backend.repository.DonacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @RequiredArgsConstructor
public class DonacionService {
    private final DonacionRepository repo;

    public List<Donacion> listarTodas() { return repo.findAll(); }
    public List<Donacion> listarPorUsuario(Long id) { return repo.findByUsuarioIdUsuario(id); }
    public List<Donacion> listarPorSolicitud(Long id) { return repo.findBySolicitudIdSolicitud(id); }
    public Donacion buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Donación no encontrada"));
    }
    public Donacion guardar(Donacion d) { return repo.save(d); }
    public void eliminar(Long id) { repo.deleteById(id); }
}