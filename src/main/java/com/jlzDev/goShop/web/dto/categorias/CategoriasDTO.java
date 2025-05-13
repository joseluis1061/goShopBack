package com.jlzDev.goShop.web.dto.categorias;

import com.jlzDev.goShop.domain.model.Productos;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriasDTO {
    private Integer idCategoria;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    //private List<Productos> productos;
}
