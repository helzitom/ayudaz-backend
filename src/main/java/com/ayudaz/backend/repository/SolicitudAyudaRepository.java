package com.ayudaz.backend.repository;

import com.ayudaz.backend.model.SolicitudAyuda;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SolicitudAyudaRepository extends JpaRepository<SolicitudAyuda, Long> {
    List<SolicitudAyuda> findByUsuarioIdUsuario(Long idUsuario);
    List<SolicitudAyuda> findByCategoriaIdCategoria(Long idCategoria);
    List<SolicitudAyuda> findByEstadoNombreEstado(String nombreEstado);
    List<SolicitudAyuda> findByUrgenciaIdUrgencia(Long idUrgencia);
}