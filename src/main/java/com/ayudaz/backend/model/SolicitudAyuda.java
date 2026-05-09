package com.ayudaz.backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name = "solicitudes_ayuda")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class SolicitudAyuda {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Long idSolicitud;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaAyuda categoria;

    @ManyToOne
    @JoinColumn(name = "id_urgencia")
    private Urgencia urgencia;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @Column(nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_solicitud")
    private LocalDateTime fechaSolicitud = LocalDateTime.now();
}