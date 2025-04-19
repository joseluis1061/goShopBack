package com.jlzDev.goShop.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO para transferir información de bodegas entre capas.
 */
@Data
public class BodegaDTO {
    private Integer idBodega;
    private String nombre;
    private String direccion;
    private String telefono;
    private Boolean estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}