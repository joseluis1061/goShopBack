package com.jlzDev.goShop.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO para transferir información de movimientos de inventario entre capas.
 */
@Data
public class MovimientoInventarioDTO {
    private Integer idMovimiento;
    private Integer idBodegaOrigen;
    private String nombreBodegaOrigen;
    private Integer idBodegaDestino;
    private String nombreBodegaDestino;
    private Integer idPuntoVentaOrigen;
    private String nombrePuntoVentaOrigen;
    private Integer idPuntoVentaDestino;
    private String nombrePuntoVentaDestino;
    private LocalDateTime fecha;
    private String tipoMovimiento;
    private String estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<DetalleMovimientoDTO> detalles;
}