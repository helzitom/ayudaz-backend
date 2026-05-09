package com.ayudaz.backend.repository;

import com.ayudaz.backend.model.TipoDonacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDonacionRepository extends JpaRepository<TipoDonacion, Long> {
}