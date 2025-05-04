package com.jlzDev.goShop.persistence.repository;

import com.jlzDev.goShop.persistence.entity.InventariosPVEntity;
import com.jlzDev.goShop.persistence.entity.ProductosEntity;
import com.jlzDev.goShop.persistence.entity.PuntosVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventariosPVCrudRepository extends JpaRepository<InventariosPVEntity, Integer> {
    List<InventariosPVEntity> findByPuntoVenta(PuntosVentaEntity puntoVenta);
    List<InventariosPVEntity> findByProducto(ProductosEntity producto);
    Optional<InventariosPVEntity> findByProductoAndPuntoVenta(ProductosEntity producto, PuntosVentaEntity puntoVenta);

    @Query("SELECT i FROM InventariosPV i WHERE i.stock < i.stockMinimo")
    List<InventariosPVEntity> findWithStockBelowMinimum();
}
