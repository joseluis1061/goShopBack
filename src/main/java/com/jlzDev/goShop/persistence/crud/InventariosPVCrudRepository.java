package com.jlzDev.goShop.persistence.crud;

import com.jlzDev.goShop.persistence.entity.InventariosPV;
import com.jlzDev.goShop.persistence.entity.Productos;
import com.jlzDev.goShop.persistence.entity.PuntosVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventariosPVCrudRepository extends JpaRepository<InventariosPV, Integer> {
    List<InventariosPV> findByPuntoVenta(PuntosVenta puntoVenta);
    List<InventariosPV> findByProducto(Productos producto);
    Optional<InventariosPV> findByProductoAndPuntoVenta(Productos producto, PuntosVenta puntoVenta);

    @Query("SELECT i FROM InventariosPV i WHERE i.stock < i.stockMinimo")
    List<InventariosPV> findWithStockBelowMinimum();
}
