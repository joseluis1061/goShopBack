package com.jlzDev.goShop.domain.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Roles {
    private Integer idRol;
    private String nombre;
    private String descripcion;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Usuarios> usuarios;
}
