package com.jlzDev.goShop.persistence.entity;

import com.jlzDev.goShop.domain.layer.EstadoMovimientoEnum;
import com.jlzDev.goShop.domain.layer.TipoMovimientoEnum;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "movimientos_inventario")
public class MovimientosInventarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimiento")
    private TipoMovimientoEnum tipoMovimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoMovimientoEnum estado;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bodega_origen")
    private BodegasEntity bodegaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bodega_destino")
    private BodegasEntity bodegaDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_punto_venta_origen")
    private PuntosVentaEntity puntoVentaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_punto_venta_destino")
    private PuntosVentaEntity puntoVentaDestino;

    @OneToMany(mappedBy = "movimientoInventario")
    private List<DetalleMovimientoEntity> movimientosInventario;

}
