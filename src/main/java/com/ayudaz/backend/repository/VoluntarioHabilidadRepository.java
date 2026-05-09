package com.ayudaz.backend.repository;

import com.ayudaz.backend.model.VoluntarioHabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VoluntarioHabilidadRepository extends JpaRepository<VoluntarioHabilidad, Long> {
    List<VoluntarioHabilidad> findByVoluntarioIdVoluntario(Long idVoluntario);
}