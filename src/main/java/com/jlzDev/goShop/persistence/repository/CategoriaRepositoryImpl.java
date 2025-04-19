package com.jlzDev.goShop.persistence.repository;

import com.jlzDev.goShop.domain.dto.CategoriaDTO;
import com.jlzDev.goShop.domain.repository.CategoriaRepository;
import com.jlzDev.goShop.persistence.crud.CategoriasCrudRepository;
import com.jlzDev.goShop.persistence.entity.Categorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private final CategoriasCrudRepository categoriasCrudRepository;

    @Autowired
    public CategoriaRepositoryImpl(CategoriasCrudRepository categoriasCrudRepository) {
        this.categoriasCrudRepository = categoriasCrudRepository;
    }

    @Override
    public List<Object> getAll() {
        List<Categorias> categorias = (List<Categorias>) categoriasCrudRepository.findAll();
        return categorias.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Object> getAllActive() {
        List<Categorias> categorias = categoriasCrudRepository.findByEstadoTrue();
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
        Optional<Categorias> categoria = Optional.ofNullable(categoriasCrudRepository.findByNombre(nombre));
        return categoria.map(this::mapToDTO);
    }

    @Override
    public Object save(Object categoria) {
        CategoriaDTO categoriaDTO = (CategoriaDTO) categoria;
        Categorias categoriaEntity = mapToEntity(categoriaDTO);
        Categorias savedCategoria = categoriasCrudRepository.save(categoriaEntity);
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
    private CategoriaDTO mapToDTO(Categorias categoria) {
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

    private Categorias mapToEntity(CategoriaDTO dto) {
        Categorias entity = new Categorias();
        entity.setIdCategoria(dto.getIdCategoria());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setEstado(dto.getEstado());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }
}