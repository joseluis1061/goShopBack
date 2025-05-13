package com.jlzDev.goShop.web.dto.categorias;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriaSimpleDTO {
    private Integer idCategoria;
    private String nombre;
}
