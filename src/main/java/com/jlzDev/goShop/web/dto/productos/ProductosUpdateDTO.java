package com.jlzDev.goShop.web.dto.productos;

import com.jlzDev.goShop.persistence.entity.CategoriasEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductosUpdateDTO {
    @NotBlank
    private Integer idProducto;
    @NotNull
    private String codigo;
    @NotNull
    private String nombre;
    private String descripcion;
    @NotNull
    @NotEmpty
    private Double precioVenta;
    private String imagenUrl;
    @NotNull
    private Boolean estado;
    @NotNull
    private Integer idCategoria; // Solo necesitamos el ID
}
