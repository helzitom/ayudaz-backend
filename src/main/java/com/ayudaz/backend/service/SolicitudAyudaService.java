package com.ayudaz.backend.service;

import com.ayudaz.backend.model.SolicitudAyuda;
import com.ayudaz.backend.repository.SolicitudAyudaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @RequiredArgsConstructor
public class SolicitudAyudaService {
    private final SolicitudAyudaRepository repo;

    public List<SolicitudAyuda> listarTodas() { return repo.findAll(); }

    public List<SolicitudAyuda> listarPorUsuario(Long idUsuario) {
        return repo.findByUsuarioIdUsuario(idUsuario);
    }

    public List<SolicitudAyuda> listarPorCategoria(Long idCategoria) {
        return repo.findByCategoriaIdCategoria(idCategoria);
    }

    public List<SolicitudAyuda> listarPorEstado(String estado) {
        return repo.findByEstadoNombreEstado(estado);
    }

    public SolicitudAyuda buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
    }

    public SolicitudAyuda guardar(SolicitudAyuda solicitud) { return repo.save(solicitud); }

    public SolicitudAyuda actualizar(Long id, SolicitudAyuda datos) {
        SolicitudAyuda s = buscarPorId(id);
        s.setTitulo(datos.getTitulo());
        s.setDescripcion(datos.getDescripcion());
        s.setCategoria(datos.getCategoria());
        s.setUrgencia(datos.getUrgencia());
        s.setEstado(datos.getEstado());
        return repo.save(s);
    }

    public void eliminar(Long id) { repo.deleteById(id); }
}