package com.jlzDev.goShop.domain.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Usuarios {
    private Integer idUsuario;
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private String telefono;
    private String direccion;
    private Boolean estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    //private Roles rol;
    //private PuntosVenta puntoVenta;
    //private List<Ventas> ventas;
}
