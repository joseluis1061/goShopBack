package com.jlzDev.goShop.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO para transferir información de categorías entre capas.
 */
@Data
public class CategoriaDTO {
    private Integer idCategoria;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Incluimos lista de productos solo en casos específicos, como un endpoint
    // que devuelva categoría con sus productos
    private List<ProductoDTO> productos;
}