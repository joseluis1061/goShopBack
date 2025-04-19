package com.jlzDev.goShop.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO para transferir información de detalles de venta entre capas.
 */
@Data
public class DetalleVentaDTO {
    private Integer idDetalle;
    private Integer idVenta;
    private Integer idProducto;
    private String nombreProducto;
    private String codigoProducto;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
    private LocalDateTime createdAt;
}
