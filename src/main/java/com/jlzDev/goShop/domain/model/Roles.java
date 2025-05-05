package com.jlzDev.goShop.domain.model;

import com.jlzDev.goShop.persistence.entity.UsuariosEntity;

import java.time.LocalDateTime;
import java.util.List;

public class Roles {
    private Integer idRol;
    private String nombre;
    private String descripcion;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    //private List<Usuarios> usuarios;
}
