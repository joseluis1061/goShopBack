package com.jlzDev.goShop.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO para transferir información de inventarios de bodegas entre capas.
 */
@Data
public class InventarioDTO {
    private Integer idInventario;
    private Integer idProducto;
    private String nombreProducto;
    private String codigoProducto;
    private Integer idBodega;
    private String nombreBodega;
    private Integer stock;
    private Integer stockMinimo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
