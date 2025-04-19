package com.jlzDev.goShop.domain.dto;

import lombok.Data;

/**
 * DTO para mostrar resúmenes de ventas (para dashboard).
 */
@Data
public class ResumenVentasDTO {
    private Integer totalVentas;
    private Double montoTotal;
    private Double ventaPromedio;
    private Integer ventasPendientes;
}