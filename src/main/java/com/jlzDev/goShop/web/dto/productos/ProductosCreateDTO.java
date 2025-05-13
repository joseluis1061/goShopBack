package com.jlzDev.goShop.web.dto.productos;

import com.jlzDev.goShop.persistence.entity.CategoriasEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductosCreateDTO {
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
    private CategoriasEntity categoria;
}
