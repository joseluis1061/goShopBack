package com.jlzDev.goShop.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO para transferir información de usuarios entre capas.
 */
@Data
public class UsuarioDTO {
    private Integer idUsuario;
    private Integer idRol;
    private String nombreRol;
    private Integer idPuntoVenta;
    private String nombrePuntoVenta;
    private String nombre;
    private String apellidos;
    private String email;
    // No incluimos password por seguridad
    private String telefono;
    private String direccion;
    private Boolean estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}