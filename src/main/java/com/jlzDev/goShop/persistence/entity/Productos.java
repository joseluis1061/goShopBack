package com.jlzDev.goShop.persistence.entity;
import jakarta.persistence.*;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id_producto;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "imagen_url")
    private String imagen_url;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Categorias categoria;

    @OneToMany(mappedBy = "producto")
    private List<Inventarios> inventarios;

    @OneToMany(mappedBy = "producto")
    private List<InventariosPV> inventariosPV;

    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detallesVenta;

    @OneToMany(mappedBy = "producto")
    private List<DetalleMovimiento> detallesMovimiento;
}
