package com.jlzDev.goShop.persistence.repository;

import com.jlzDev.goShop.persistence.entity.PuntosVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PuntosVentaCrudRepository extends JpaRepository<PuntosVentaEntity, Integer> {
    List<PuntosVentaEntity> findByEstadoTrue();
    PuntosVentaEntity findByNombre(String nombre);
}