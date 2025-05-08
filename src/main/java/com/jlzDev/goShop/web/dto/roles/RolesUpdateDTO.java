package com.jlzDev.goShop.web.dto.roles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolesUpdateDTO {
    private Integer idRol;
    private String nombre;
    private String descripcion;
}
