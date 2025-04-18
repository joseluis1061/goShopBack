package com.jlzDev.goShop.persistence.crud;

import com.jlzDev.goShop.persistence.entity.Bodegas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BodegasCrudRepository extends JpaRepository<Bodegas, Integer> {

    List<Bodegas> findByEstadoTrue();
    Bodegas findByNombre(String nombre);
}
