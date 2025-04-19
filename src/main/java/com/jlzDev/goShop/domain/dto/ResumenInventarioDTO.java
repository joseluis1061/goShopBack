package com.jlzDev.goShop.domain.dto;

import lombok.Data;

/**
 * DTO para mostrar resúmenes de inventario (para dashboard).
 */
@Data
public class ResumenInventarioDTO {
    private Integer totalProductos;
    private Integer productosStockBajo;
    private Integer stockTotal;
    private Double valorInventario;
}
