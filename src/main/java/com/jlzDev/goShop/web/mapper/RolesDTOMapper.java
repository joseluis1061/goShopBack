package com.jlzDev.goShop.web.mapper;

import com.jlzDev.goShop.domain.model.Roles;
import com.jlzDev.goShop.web.dto.roles.RolesDTO;
import org.mapstruct.Mapper;

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
}
