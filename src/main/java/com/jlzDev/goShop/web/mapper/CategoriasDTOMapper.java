package com.jlzDev.goShop.web.mapper;


import com.jlzDev.goShop.domain.model.Categorias;
import com.jlzDev.goShop.web.dto.categorias.CategoriasCreateDTO;
import com.jlzDev.goShop.web.dto.categorias.CategoriasDTO;
import com.jlzDev.goShop.web.dto.categorias.CategoriasUpdateDTO;
import jakarta.validation.constraints.Size;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriasDTOMapper {
    // Domain to DTO
    CategoriasDTO toCategoriaDTO(Categorias categoria);
    List<CategoriasDTO> toCategoriasDTO(List<Categorias> categorias);

    // DTO to Domain
    Categorias toCategoria(CategoriasDTO categoriaDTO);

    // CreateDTO to Domain
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "estado", source = "estado")
    Categorias toCategoriaFromCreateDTO(CategoriasCreateDTO createDTO);

    // UpdateDTO to Domain
    @Mapping(target = "idCategoria", source = "idCategoria")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "estado", source = "estado")
    Categorias toCategoriaFromUpdateDTO(CategoriasUpdateDTO updateDTO);
}
