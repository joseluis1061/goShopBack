package com.jlzDev.goShop.persistence.mapper;

import com.jlzDev.goShop.domain.model.Roles;
import com.jlzDev.goShop.persistence.entity.RolesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsuariosMapper.class})
public interface RolesMapper {
    // Entity → Domain De RolesEntity a Roles
    @Mapping(source = "idRol", target = "idRol")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    @Mapping(source = "usuarios", target = "usuarios")
    Roles toRol(RolesEntity entity);

    List<Roles> toRoles(List<RolesEntity> entities);

    // Domain → Entity De Roles a RolesEntity
    @Mapping(source = "idRol", target = "idRol")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    @Mapping(target = "usuarios", ignore = true)
    RolesEntity toRolEntity(Roles entity);

}
