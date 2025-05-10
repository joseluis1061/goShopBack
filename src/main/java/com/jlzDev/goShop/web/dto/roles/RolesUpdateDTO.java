package com.jlzDev.goShop.web.dto.roles;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolesUpdateDTO {
    @NotNull
    private Integer idRol;
    @NotBlank
    private String nombre;
    @Size(max = 255)
    private String descripcion;
}
