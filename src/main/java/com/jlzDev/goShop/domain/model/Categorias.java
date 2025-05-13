package com.jlzDev.goShop.domain.model;

import com.jlzDev.goShop.persistence.entity.ProductosEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categorias {
    private Integer idCategoria;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    //private List<Productos> productos;
}
