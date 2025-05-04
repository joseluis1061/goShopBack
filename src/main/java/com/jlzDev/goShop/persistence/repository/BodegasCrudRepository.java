package com.jlzDev.goShop.persistence.repository;

import com.jlzDev.goShop.persistence.entity.BodegasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BodegasCrudRepository extends JpaRepository<BodegasEntity, Integer> {

    List<BodegasEntity> findByEstadoTrue();
    BodegasEntity findByNombre(String nombre);
}
