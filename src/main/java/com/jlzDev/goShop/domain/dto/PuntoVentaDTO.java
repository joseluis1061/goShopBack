package com.jlzDev.goShop.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO para transferir información de puntos de venta entre capas.
 */
@Data
public class PuntoVentaDTO {
    private Integer idPuntoVenta;
    private String nombre;
    private String direccion;
    private String telefono;
    private Boolean estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}