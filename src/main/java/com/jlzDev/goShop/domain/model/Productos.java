package com.jlzDev.goShop.domain.model;

import com.jlzDev.goShop.persistence.entity.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Productos {
    private Integer idProducto;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Double precioVenta;
    private String imagenUrl;
    private Boolean estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    //private CategoriasEntity categoria;
    //private List<Inventarios> inventarios;
    //private List<InventariosPV> inventariosPV;
    //private List<DetalleVenta> detallesVenta;
    //private List<DetalleMovimiento> detallesMovimiento;
}
