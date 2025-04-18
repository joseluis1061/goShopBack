package com.jlzDev.goShop.persistence.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
@Entity
@Table(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "rol")
    private List<Usuarios> usuarios;
}
