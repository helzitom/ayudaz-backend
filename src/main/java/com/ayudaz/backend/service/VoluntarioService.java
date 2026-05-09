package com.ayudaz.backend.service;

import com.ayudaz.backend.model.Voluntario;
import com.ayudaz.backend.repository.VoluntarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @RequiredArgsConstructor
public class VoluntarioService {
    private final VoluntarioRepository repo;

    public List<Voluntario> listarTodos() { return repo.findAll(); }

    public Voluntario buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Voluntario no encontrado"));
    }

    public Voluntario buscarPorUsuario(Long idUsuario) {
        return repo.findByUsuarioIdUsuario(idUsuario)
                .orElseThrow(() -> new RuntimeException("Voluntario no encontrado"));
    }

    public Voluntario guardar(Voluntario v) { return repo.save(v); }

    public Voluntario actualizar(Long id, Voluntario datos) {
        Voluntario v = buscarPorId(id);
        v.setDisponibilidad(datos.getDisponibilidad());
        v.setZonaApoyo(datos.getZonaApoyo());
        return repo.save(v);
    }

    public void eliminar(Long id) { repo.deleteById(id); }
}