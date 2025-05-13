package com.jlzDev.goShop.web.dto.productos;

import com.jlzDev.goShop.persistence.entity.CategoriasEntity;
import com.jlzDev.goShop.web.dto.categorias.CategoriaSimpleDTO;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductosDTO {
    private Integer idProducto;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Double precioVenta;
    private String imagenUrl;
    private Boolean estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private CategoriaSimpleDTO categoria;
}
