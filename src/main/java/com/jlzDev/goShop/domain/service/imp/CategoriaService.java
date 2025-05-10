package com.jlzDev.goShop.domain.service.imp;

import com.jlzDev.goShop.domain.dto.CategoriaDTO;
import com.jlzDev.goShop.domain.repository.CategoriaRepository;
import com.jlzDev.goShop.persistence.mapper.CategoriasMapper;
import com.jlzDev.goShop.persistence.repository.CategoriasCrudRepository;
import com.jlzDev.goShop.persistence.entity.CategoriasEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService implements CategoriaRepository {

    private final CategoriasCrudRepository categoriasCrudRepository;
    private final CategoriasMapper categoriasMapper;

    @Autowired
    public CategoriaService(CategoriasCrudRepository categoriasCrudRepository, CategoriasMapper categoriasMapper) {
        this.categoriasCrudRepository = categoriasCrudRepository;
        this.categoriasMapper = categoriasMapper;
    }

    @Override
    public List<Object> getAll() {
        List<CategoriasEntity> categorias = (List<CategoriasEntity>) categoriasCrudRepository.findAll();
        return categorias.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Object> getAllActive() {
        List<CategoriasEntity> categorias = categoriasCrudRepository.findByEstadoTrue();
        return categorias.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Object> getCategoria(int categoriaId) {
        return categoriasCrudRepository.findById(categoriaId)
                .map(this::mapToDTO);
    }

    @Override
    public Optional<Object> getByNombre(String nombre) {
        Optional<CategoriasEntity> categoria = Optional.ofNullable(categoriasCrudRepository.findByNombre(nombre));
        return categoria.map(this::mapToDTO);
    }

    @Override
    public Object save(Object categoria) {
        CategoriaDTO categoriaDTO = (CategoriaDTO) categoria;
        CategoriasEntity categoriaEntity = mapToEntity(categoriaDTO);
        CategoriasEntity savedCategoria = categoriasCrudRepository.save(categoriaEntity);
        return mapToDTO(savedCategoria);
    }

    @Override
    public boolean delete(int categoriaId) {
        if (categoriasCrudRepository.existsById(categoriaId)) {
            categoriasCrudRepository.deleteById(categoriaId);
            return true;
        }
        return false;
    }

    // Métodos de mapeo entre entidad y DTO
    private CategoriaDTO mapToDTO(CategoriasEntity categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setIdCategoria(categoria.getIdCategoria());
        dto.setNombre(categoria.getNombre());
        dto.setDescripcion(categoria.getDescripcion());
        dto.setEstado(categoria.getEstado());
        dto.setCreatedAt(categoria.getCreatedAt());
        dto.setUpdatedAt(categoria.getUpdatedAt());
        // No incluimos la lista de productos por defecto para evitar ciclos
        return dto;
    }

    private CategoriasEntity mapToEntity(CategoriaDTO dto) {
        CategoriasEntity entity = new CategoriasEntity();
        entity.setIdCategoria(dto.getIdCategoria());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setEstado(dto.getEstado());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }
}