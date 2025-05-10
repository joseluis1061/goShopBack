package com.jlzDev.goShop.persistence.mapper;

import com.jlzDev.goShop.domain.model.Productos;
import com.jlzDev.goShop.persistence.entity.ProductosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductosMapper {
    // De ProductosEntity a Productos
    @Mapping(source = "idProducto", target = "idProducto")
    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "precioVenta", target = "precioVenta")
    @Mapping(source = "imagenUrl", target = "imagenUrl")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    //@Mapping(source = "categoria", target = "categoria")
    //@Mapping(source = "inventarios", target = "inventarios")
    //@Mapping(source = "inventariosPV", target = "inventariosPV")
    //@Mapping(source = "detallesVenta", target = "detallesVenta")
    //@Mapping(source = "detallesMovimiento", target = "detallesMovimiento")
    Productos toProducto(ProductosEntity entity);

    List<Productos> toProductos(List<ProductosEntity> entities);

    // De Productos a ProductosEntity
    @Mapping(source = "idProducto", target = "idProducto")
    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "precioVenta", target = "precioVenta")
    @Mapping(source = "imagenUrl", target = "imagenUrl")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    //@Mapping(source = "categoria", target = "categoria")
    //@Mapping(source = "inventarios", target = "inventarios")
    //@Mapping(source = "inventariosPV", target = "inventariosPV")
    //@Mapping(source = "detallesVenta", target = "detallesVenta")
    //@Mapping(source = "detallesMovimiento", target = "detallesMovimiento")
    ProductosEntity toProductoEntity(Productos entity);

}
