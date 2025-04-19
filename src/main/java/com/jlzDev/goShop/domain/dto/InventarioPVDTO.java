package com.jlzDev.goShop.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO para transferir información de inventarios de puntos de venta entre capas.
 */
@Data
public class InventarioPVDTO {
    private Integer idInventarioPV;
    private Integer idProducto;
    private String nombreProducto;
    private String codigoProducto;
    private Integer idPuntoVenta;
    private String nombrePuntoVenta;
    private Integer stock;
    private Integer stockMinimo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
