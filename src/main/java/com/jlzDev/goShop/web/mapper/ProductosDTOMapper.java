package com.jlzDev.goShop.web.mapper;

import com.jlzDev.goShop.domain.model.Productos;
import com.jlzDev.goShop.persistence.entity.CategoriasEntity;
import com.jlzDev.goShop.web.dto.productos.ProductosCreateDTO;
import com.jlzDev.goShop.web.dto.productos.ProductosDTO;
import com.jlzDev.goShop.web.dto.productos.ProductosUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductosDTOMapper {
    // Domain to DTO
    List<ProductosDTO> toProductosDTO(List<Productos> productos);
    ProductosDTO toProductoDto(Productos producto);

    // DTO to Domain
    Productos toProductos(ProductosDTO productosDTO);

    // CreateDTO to Domain
    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "precioVenta", target = "precioVenta")
    @Mapping(source = "imagenUrl", target = "imagenUrl")
    @Mapping(source = "estado", target = "estado")
    @Mapping(target = "categoria", ignore = true)
    Productos toProductoFromCreateDTO(ProductosCreateDTO productosCreateDTO);

    // UpdateDTO to Domain
    @Mapping(source = "idProducto", target = "idProducto")
    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "precioVenta", target = "precioVenta")
    @Mapping(source = "imagenUrl", target = "imagenUrl")
    @Mapping(source = "estado", target = "estado")
    @Mapping(target = "categoria", ignore = true)
    Productos toProductoFromUpdateDTO(ProductosUpdateDTO productosCreateDTO);
}
