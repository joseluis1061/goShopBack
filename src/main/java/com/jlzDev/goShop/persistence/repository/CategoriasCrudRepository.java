package com.jlzDev.goShop.persistence.repository;

import com.jlzDev.goShop.persistence.entity.CategoriasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriasCrudRepository extends JpaRepository<CategoriasEntity, Integer> {
    List<CategoriasEntity> findByEstadoTrue();
    Optional<CategoriasEntity> findByNombre(String nombre);
}
