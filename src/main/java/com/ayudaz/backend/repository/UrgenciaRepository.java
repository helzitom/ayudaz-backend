package com.ayudaz.backend.repository;

import com.ayudaz.backend.model.Urgencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrgenciaRepository extends JpaRepository<Urgencia, Long> {
}