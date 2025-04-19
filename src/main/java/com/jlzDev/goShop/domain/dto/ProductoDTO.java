package com.jlzDev.goShop.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO para transferir información de productos entre capas.
 */
@Data
public class ProductoDTO {
    private Integer idProducto;
    private Integer idCategoria;
    private String nombreCategoria;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Double precioVenta;
    private String imagenUrl;
    private Boolean estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // No incluimos colecciones de inventarios o detalles para evitar cargas innecesarias
}
