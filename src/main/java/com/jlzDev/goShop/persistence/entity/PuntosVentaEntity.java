package com.jlzDev.goShop.persistence.entity;
import jakarta.persistence.*;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="puntos_venta")
public class PuntosVentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_punto_venta")
    private Integer idPuntoVenta;

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

    @OneToMany(mappedBy = "puntoVenta")
    private List<UsuariosEntity> usuarios;

    @OneToMany(mappedBy = "puntoVenta")
    private List<VentasEntity> ventas;

    @OneToMany(mappedBy = "puntoVenta")
    private List<InventariosPVEntity> inventariosPV;

    @OneToMany(mappedBy = "puntoVentaOrigen")
    private List<MovimientosInventarioEntity> movimientosOrigen;

    @OneToMany(mappedBy = "puntoVentaDestino")
    private List<MovimientosInventarioEntity> movimientosDestino;
}
