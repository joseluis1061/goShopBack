package com.jlzDev.goShop.persistence.mapper;

import com.jlzDev.goShop.domain.model.Categorias;
import com.jlzDev.goShop.domain.model.Productos;
import com.jlzDev.goShop.persistence.entity.CategoriasEntity;
import com.jlzDev.goShop.persistence.entity.ProductosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoriasMapper.class})
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
    //@Mapping(source = "inventarios", target = "inventarios")
    //@Mapping(source = "inventariosPV", target = "inventariosPV")
    //@Mapping(source = "detallesVenta", target = "detallesVenta")
    //@Mapping(source = "detallesMovimiento", target = "detallesMovimiento")
    @Mapping(target = "categoria", source = "categoria", qualifiedByName = "categoriaToCategoriaSimple")

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
    @Mapping(target = "categoria", source = "categoria", qualifiedByName = "categoriaToCategoriaEntity")
    //@Mapping(target = "inventarios", ignore = true)
    //@Mapping(target = "inventariosPV", ignore = true)
    //@Mapping(target = "detallesVenta", ignore = true)
    //@Mapping(target = "detallesMovimiento", ignore = true)
    ProductosEntity toProductoEntity(Productos entity);

    @Named("categoriaToCategoriaSimple")
    default Categorias categoriaToCategoriaSimple(CategoriasEntity categoria) {
        if (categoria == null) {
            return null;
        }

        Categorias categoriaSimple = new Categorias();
        categoriaSimple.setIdCategoria(categoria.getIdCategoria());
        categoriaSimple.setNombre(categoria.getNombre());
        // No incluimos otros campos

        return categoriaSimple;
    }

    @Named("categoriaToCategoriaEntity")
    default CategoriasEntity categoriaToCategoriaEntity(Categorias categoria) {
        if (categoria == null) {
            return null;
        }

        // Para la creación/actualización, solo necesitamos el ID
        CategoriasEntity categoriaEntity = new CategoriasEntity();
        categoriaEntity.setIdCategoria(categoria.getIdCategoria());

        return categoriaEntity;
    }

}