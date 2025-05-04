package com.jlzDev.goShop.persistence.repository;

import com.jlzDev.goShop.persistence.entity.CategoriasEntity;
import com.jlzDev.goShop.persistence.entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductosCrudRepository extends JpaRepository<ProductosEntity, Integer> {
    Optional<ProductosEntity> findByCodigo(String codigo);
    List<ProductosEntity> findByNombreContaining(String nombre);
    List<ProductosEntity> findByCategoria(CategoriasEntity categoria);
    List<ProductosEntity> findByEstadoTrue();

    @Query("SELECT p FROM Productos p WHERE p.precioVenta <= :precio AND p.estado = true")
    List<ProductosEntity> findByPrecioLessThanEqual(@Param("precio") Double precio);

    @Query("SELECT p FROM Productos p WHERE p.precioVenta >= :precioMenor  AND p.precioVenta <= :precioMayor AND p.estado = true")
    List<ProductosEntity> findByPrecioVentaBetweenAndEstadoTrue(@Param("precioMenor") Double precioMenor, @Param("precioMayor") Double precioMayor);
}
