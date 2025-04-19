package com.jlzDev.goShop.persistence.crud;

import com.jlzDev.goShop.persistence.entity.Bodegas;
import com.jlzDev.goShop.persistence.entity.Inventarios;
import com.jlzDev.goShop.persistence.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventariosCrudRepository extends JpaRepository<Inventarios, Integer> {
    List<Inventarios> findByBodega(Bodegas bodega);
    List<Inventarios> findByProducto(Productos producto);
    Optional<Inventarios> findByProductoAndBodega(Productos producto, Bodegas bodega);

    @Query("SELECT i FROM Inventarios i WHERE i.stock < i.stockMinimo")
    List<Inventarios> findWithStockBelowMinimum();
}
