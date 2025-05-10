package com.jlzDev.goShop.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "bodegas")
public class BodegasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bodega")
    private Integer idBodega;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "bodega")
    private List<InventariosEntity> inventarios;

    @OneToMany(mappedBy = "bodegaOrigen")
    private List<MovimientosInventarioEntity> movimientosOrigen;

    @OneToMany(mappedBy = "bodegaDestino")
    private List<MovimientosInventarioEntity> movimientosDestino;
}
