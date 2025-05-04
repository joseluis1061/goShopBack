package com.jlzDev.goShop.persistence.repository;

import com.jlzDev.goShop.persistence.entity.BodegasEntity;
import com.jlzDev.goShop.persistence.entity.InventariosEntity;
import com.jlzDev.goShop.persistence.entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventariosCrudRepository extends JpaRepository<InventariosEntity, Integer> {
    List<InventariosEntity> findByBodega(BodegasEntity bodega);
    List<InventariosEntity> findByProducto(ProductosEntity producto);
    Optional<InventariosEntity> findByProductoAndBodega(ProductosEntity producto, BodegasEntity bodega);

    @Query("SELECT i FROM Inventarios i WHERE i.stock < i.stockMinimo")
    List<InventariosEntity> findWithStockBelowMinimum();
}
