package com.jlzDev.goShop.web.dto.categorias;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriasUpdateDTO {
    @NotBlank
    private Integer idCategoria;
    @NotNull
    @Size(max = 250)
    private String nombre;
    @Size(max = 1200)
    private String descripcion;
    private Boolean estado;
}
