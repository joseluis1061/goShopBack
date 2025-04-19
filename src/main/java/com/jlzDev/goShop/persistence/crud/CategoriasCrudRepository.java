package com.jlzDev.goShop.persistence.crud;

import com.jlzDev.goShop.persistence.entity.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriasCrudRepository extends JpaRepository<Categorias, Integer> {
    List<Categorias> findByEstadoTrue();
    Categorias findByNombre(String nombre);
}
