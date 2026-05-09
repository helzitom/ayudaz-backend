package com.ayudaz.backend.repository;

import com.ayudaz.backend.model.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {
    List<UsuarioRol> findByUsuarioIdUsuario(Long idUsuario);
}