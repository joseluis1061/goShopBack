package com.jlzDev.goShop.domain.service.imp;

import com.jlzDev.goShop.domain.repository.CategoriaRepository;
import com.jlzDev.goShop.domain.model.Categorias;
import com.jlzDev.goShop.persistence.mapper.CategoriasMapper;
import com.jlzDev.goShop.persistence.repository.CategoriasCrudRepository;
import com.jlzDev.goShop.persistence.entity.CategoriasEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementación de la interfaz CategoriaService.
 * Proporciona la lógica de negocio para las operaciones relacionadas con Categorias.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CategoriaService implements CategoriaRepository {

    private final CategoriasCrudRepository categoriasCrudRepository;
    private final CategoriasMapper categoriasMapper;

    /*@Autowired
    public CategoriaService(CategoriasCrudRepository categoriasCrudRepository, CategoriasMapper categoriasMapper) {
        this.categoriasCrudRepository = categoriasCrudRepository;
        this.categoriasMapper = categoriasMapper;
    }*/

    @Override
    @Transactional(readOnly = true)
    public List<Categorias> getAll() {
        List<CategoriasEntity> entities = (List<CategoriasEntity>) categoriasCrudRepository.findAll();
        return categoriasMapper.toCategorias(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categorias> getAllActive() {
        List<CategoriasEntity> entities = categoriasCrudRepository.findByEstadoTrue();
        return categoriasMapper.toCategorias(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Categorias> getCategoria(int categoriaId) {
        return categoriasCrudRepository.findById(categoriaId)
                .map(categoriasMapper::toCategoria);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Categorias> getByNombre(String nombre) {
        return categoriasCrudRepository.findByNombre(nombre)
                .map(categoriasMapper::toCategoria);
    }

    @Override
    @Transactional
    public Categorias save(Categorias categoria) {
        log.info("Guardando nueva categoría: {}", categoria);
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula");
        }

        if (categoria.getNombre() == null || categoria.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoría no puede ser nulo o vacío");
        }
        CategoriasEntity entity = categoriasMapper.toCategoriasEntity(categoria);
        CategoriasEntity entitySave = categoriasCrudRepository.save(entity);
        return categoriasMapper.toCategoria(entitySave);
    }

    @Override
    @Transactional
    public Optional<Categorias> update(int categoriaId, Categorias categoria){
        log.info("Actualizando categoria con ID: {}", categoriaId);

        if (categoriaId <= 0) {
            throw new IllegalArgumentException("El id de categoria no puede ser 0 o negativo");
        }

        if (categoria == null) {
            throw new IllegalArgumentException("Categoria no puede ser nulo");
        }

        if (categoria.getNombre() == null || categoria.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de categoria no puede ser nulo o vacío");
        }

        // Verificar si el rol existe
        if (!existsById(categoriaId)) {
            log.warn("No se encontró categoria con ID: {}", categoriaId);
            return Optional.empty();
        }

        CategoriasEntity entity = categoriasMapper.toCategoriasEntity(categoria);
        CategoriasEntity entitySave = categoriasCrudRepository.save(entity);
        return Optional.of(categoriasMapper.toCategoria(entitySave));
    }

    @Override
    @Transactional
    public boolean delete(int categoriaId) {
        if (categoriasCrudRepository.existsById(categoriaId)) {
            categoriasCrudRepository.deleteById(categoriaId);
            return true;
        }
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(int categoriaId) {
        return categoriasCrudRepository.existsById(categoriaId);
    }
}