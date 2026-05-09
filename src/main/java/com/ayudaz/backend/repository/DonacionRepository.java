package com.ayudaz.backend.repository;

import com.ayudaz.backend.model.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DonacionRepository extends JpaRepository<Donacion, Long> {
    List<Donacion> findByUsuarioIdUsuario(Long idUsuario);
    List<Donacion> findBySolicitudIdSolicitud(Long idSolicitud);
}