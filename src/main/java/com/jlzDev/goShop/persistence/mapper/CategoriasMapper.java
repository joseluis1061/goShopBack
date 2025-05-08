package com.jlzDev.goShop.persistence.mapper;

import com.jlzDev.goShop.domain.model.Categorias;
import com.jlzDev.goShop.persistence.entity.CategoriasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriasMapper {
    // Entity → Domain De RolesEntity a Roles
    @Mapping(source = "idCategoria", target = "idCategoria")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    //@Mapping(source = "productos", target = "productos")
    Categorias toCategoria(CategoriasEntity entity);

    List<Categorias> toCategorias(List<CategoriasEntity> entities);

    // Domain → Entity De Roles a RolesEntity
    @Mapping(source = "idCategoria", target = "idCategoria")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    //@Mapping(target = "productos", ignore = true)
    CategoriasEntity toCategoriasEntity(Categorias entity);
}
