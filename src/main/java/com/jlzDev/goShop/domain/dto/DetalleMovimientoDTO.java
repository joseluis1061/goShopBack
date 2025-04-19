package com.jlzDev.goShop.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO para transferir información de detalles de movimientos entre capas.
 */
@Data
public class DetalleMovimientoDTO {
    private Integer idDetalleMovimiento;
    private Integer idMovimiento;
    private Integer idProducto;
    private String nombreProducto;
    private String codigoProducto;
    private Integer cantidad;
    private LocalDateTime createdAt;
}
