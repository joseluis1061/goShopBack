package com.jlzDev.goShop.web.mapper;

import com.jlzDev.goShop.domain.model.Categorias;
import com.jlzDev.goShop.domain.model.Productos;
import com.jlzDev.goShop.web.dto.categorias.CategoriaSimpleDTO;
import com.jlzDev.goShop.web.dto.productos.ProductosCreateDTO;
import com.jlzDev.goShop.web.dto.productos.ProductosDTO;
import com.jlzDev.goShop.web.dto.productos.ProductosUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductosDTOMapper {
    // Domain to DTO
    List<ProductosDTO> toProductosDTO(List<Productos> productos);

    @Mapping(source = "categoria", target = "categoria", qualifiedByName = "categoriaToCategoriaSimpleDTO")
    ProductosDTO toProductoDto(Productos producto);

    // DTO to Domain
    @Mapping(source = "categoria", target = "categoria", qualifiedByName = "categoriaSimpleDTOToCategoria")
    Productos toProductos(ProductosDTO productosDTO);

    // CreateDTO to Domain
    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "precioVenta", target = "precioVenta")
    @Mapping(source = "imagenUrl", target = "imagenUrl")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "idCategoria", target = "categoria", qualifiedByName = "idToCategorias")
    Productos toProductoFromCreateDTO(ProductosCreateDTO productosCreateDTO);

    // UpdateDTO to Domain
    @Mapping(source = "idProducto", target = "idProducto")
    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "precioVenta", target = "precioVenta")
    @Mapping(source = "imagenUrl", target = "imagenUrl")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "idCategoria", target = "categoria", qualifiedByName = "idToCategorias")
    Productos toProductoFromUpdateDTO(ProductosUpdateDTO productosUpdateDTO);

    @Named("categoriaToCategoriaSimpleDTO")
    default CategoriaSimpleDTO categoriaToCategoriaSimpleDTO(Categorias categoria) {
        if (categoria == null) {
            return null;
        }

        CategoriaSimpleDTO categoriaDTO = new CategoriaSimpleDTO();
        categoriaDTO.setIdCategoria(categoria.getIdCategoria());
        categoriaDTO.setNombre(categoria.getNombre());

        return categoriaDTO;
    }

    @Named("categoriaSimpleDTOToCategoria")
    default Categorias categoriaSimpleDTOToCategoria(CategoriaSimpleDTO categoriaDTO) {
        if (categoriaDTO == null) {
            return null;
        }

        Categorias categoria = new Categorias();
        categoria.setIdCategoria(categoriaDTO.getIdCategoria());
        categoria.setNombre(categoriaDTO.getNombre());

        return categoria;
    }

    @Named("idToCategorias")
    default Categorias idToCategorias(Integer idCategoria) {
        if (idCategoria == null) {
            return null;
        }

        Categorias categoria = new Categorias();
        categoria.setIdCategoria(idCategoria);

        return categoria;
    }
}