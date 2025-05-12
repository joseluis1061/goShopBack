package com.jlzDev.goShop.web.dto.categorias;

import com.jlzDev.goShop.domain.model.Productos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriasCreateDTO {
    @NotNull
    @Size(max = 250)
    private String nombre;
    @Size(max = 1200)
    private String descripcion;
    private Boolean estado;
    //private List<Productos> productos;
}
