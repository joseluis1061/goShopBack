package com.jlzDev.goShop.persistence.repository;

import com.jlzDev.goShop.persistence.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesCrudRepository extends JpaRepository<RolesEntity, Integer> {
    RolesEntity findByNombre(String nombre);
}