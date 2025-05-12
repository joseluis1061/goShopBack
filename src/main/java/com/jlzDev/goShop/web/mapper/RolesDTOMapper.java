package com.jlzDev.goShop.web.mapper;

import com.jlzDev.goShop.domain.model.Roles;
import com.jlzDev.goShop.web.dto.roles.RolesCreateDTO;
import com.jlzDev.goShop.web.dto.roles.RolesDTO;
import com.jlzDev.goShop.web.dto.roles.RolesUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper para convertir entre el modelo de dominio Roles y web RolesDTO.
 */
@Mapper(componentModel = "spring")
public interface RolesDTOMapper {
    // Domain to DTO
    RolesDTO toRolDTO(Roles rol);
    List<RolesDTO> toRolesDTO(List<Roles> roles);

    // DTO to Domain
    Roles toRol(RolesDTO rolDTO);

    // CreateDTO to Domain
    @Mapping(target = "idRol", ignore = true) // Ignoramos el ID ya que será generado
    @Mapping(target = "createdAt", ignore = true) // Ignoramos la fecha de creación
    @Mapping(target = "updatedAt", ignore = true) // Ignoramos la fecha de actualización
    Roles toRolFromCreateDTO(RolesCreateDTO createRolDTO);

    // DTO de actualización
    @Mapping(target = "usuarios", ignore = true) // Asumiendo que tienes esta relación
    @Mapping(target = "createdAt", ignore = true) // Se establecerá manualmente
    @Mapping(target = "updatedAt", ignore = true) // Se establecerá manualmente
    Roles toRolFromUpdateDTO(RolesUpdateDTO updateDTO);
}
