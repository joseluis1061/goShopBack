package com.jlzDev.goShop.persistence.mapper;

import com.jlzDev.goShop.domain.model.Usuarios;
import com.jlzDev.goShop.persistence.entity.UsuariosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuariosMapper {
    // Entity → Domain De UsuariosEntity a Usuarios
    @Mapping(source = "idUsuario", target = "idUsuario")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellidos", target = "apellidos")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    //@Mapping(source = "rol", target = "rol")
    //@Mapping(source = "puntoVenta", target = "puntoVenta")
    //@Mapping(source = "ventas", target = "ventas")
    Usuarios toUsuario(UsuariosEntity entity);

    List<Usuarios> toUsuarios(List<UsuariosEntity> entities);

    // Domain → Entity De Roles a RolesEntity
    @Mapping(source = "idUsuario", target = "idUsuario")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellidos", target = "apellidos")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    //@Mapping(target = "rol", ignore = true)
    //@Mapping(target = "puntoVenta", ignore = true)
    //@Mapping(target = "ventas", ignore = true)
    UsuariosEntity toUsuariosEntity(Usuarios entity);
}
