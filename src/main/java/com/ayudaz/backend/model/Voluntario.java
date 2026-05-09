package com.ayudaz.backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity @Table(name = "voluntarios")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Voluntario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voluntario")
    private Long idVoluntario;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private String disponibilidad;

    @Column(name = "zona_apoyo")
    private String zonaApoyo;

    @OneToMany(mappedBy = "voluntario", cascade = CascadeType.ALL)
    private List<VoluntarioHabilidad> habilidades;
}