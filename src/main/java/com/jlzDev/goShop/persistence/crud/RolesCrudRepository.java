package com.jlzDev.goShop.persistence.crud;

import com.jlzDev.goShop.persistence.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesCrudRepository extends JpaRepository<Roles, Integer> {
    Roles findByNombre(String nombre);
}