package com.ayudaz.backend.repository;

import com.ayudaz.backend.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    List<Estado> findByTipoTabla(String tipoTabla);
}