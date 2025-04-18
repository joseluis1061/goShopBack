package com.jlzDev.goShop.persistence.crud;

import com.jlzDev.goShop.persistence.entity.Categorias;
import com.jlzDev.goShop.persistence.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductosCrudRepository extends JpaRepository<Productos, Integer> {
    Optional<Productos> findByCodigo(String codigo);
    List<Productos> findByNombreContaining(String nombre);
    List<Productos> findByCategoria(Categorias categoria);
    List<Productos> findByEstadoTrue();

    @Query("SELECT p FROM Productos p WHERE p.precioVenta <= :precio AND p.estado = true")
    List<Productos> findByPrecioLessThanEqual(@Param("precio") Double precio);
}
