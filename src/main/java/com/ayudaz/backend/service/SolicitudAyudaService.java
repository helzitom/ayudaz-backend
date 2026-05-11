package com.ayudaz.backend.service;

import com.ayudaz.backend.model.*;
import com.ayudaz.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudAyudaService {

    private final SolicitudAyudaRepository repo;
    private final UsuarioRepository usuarioRepo;
    private final CategoriaAyudaRepository categoriaRepo;
    private final UrgenciaRepository urgenciaRepo;
    private final EstadoRepository estadoRepo;

    public List<SolicitudAyuda> listarTodas() {
        return repo.findAll();
    }

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
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
    }

    // =========================
    // FIX PRINCIPAL AQUÍ
    // =========================
    public SolicitudAyuda guardar(SolicitudAyuda solicitud) {

        // 🔥 EVITA NULLS SILENCIOSOS
        if (solicitud.getUrgencia() != null
                && solicitud.getUrgencia().getIdUrgencia() != null) {

            Urgencia urgencia = urgenciaRepo.findById(
                    solicitud.getUrgencia().getIdUrgencia()
            ).orElseThrow(() -> new RuntimeException("Urgencia no encontrada"));

            solicitud.setUrgencia(urgencia);
        }

        if (solicitud.getEstado() != null
                && solicitud.getEstado().getIdEstado() != null) {

            Estado estado = estadoRepo.findById(
                    solicitud.getEstado().getIdEstado()
            ).orElseThrow(() -> new RuntimeException("Estado no encontrado"));

            solicitud.setEstado(estado);
        }

        if (solicitud.getCategoria() != null
                && solicitud.getCategoria().getIdCategoria() != null) {

            CategoriaAyuda categoria = categoriaRepo.findById(
                    solicitud.getCategoria().getIdCategoria()
            ).orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

            solicitud.setCategoria(categoria);
        }

        if (solicitud.getUsuario() != null
                && solicitud.getUsuario().getIdUsuario() != null) {

            Usuario usuario = usuarioRepo.findById(
                    solicitud.getUsuario().getIdUsuario()
            ).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            solicitud.setUsuario(usuario);
        }

        return repo.save(solicitud);
    }

    public SolicitudAyuda actualizar(Long id, SolicitudAyuda datos) {

        SolicitudAyuda s = buscarPorId(id);

        s.setTitulo(datos.getTitulo());
        s.setDescripcion(datos.getDescripcion());

        s.setCategoria(datos.getCategoria());
        s.setUrgencia(datos.getUrgencia());
        s.setEstado(datos.getEstado());

        return repo.save(s);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}