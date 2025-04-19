package com.jlzDev.goShop.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO para transferir información de ventas entre capas.
 */
@Data
public class VentaDTO {
    private Integer idVenta;
    private Integer idUsuario;
    private String nombreUsuario;
    private Integer idPuntoVenta;
    private String nombrePuntoVenta;
    private String numeroFactura;
    private LocalDateTime fecha;
    private Double subtotal;
    private Double impuesto;
    private Double total;
    private String estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<DetalleVentaDTO> detalles;
}