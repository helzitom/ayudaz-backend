package com.ayudaz.backend.repository;

import com.ayudaz.backend.model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {
    Optional<Voluntario> findByUsuarioIdUsuario(Long idUsuario);
    List<Voluntario> findByZonaApoyo(String zonaApoyo);
}