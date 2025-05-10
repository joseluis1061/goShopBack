package com.jlzDev.goShop.domain.model;

import com.jlzDev.goShop.persistence.entity.InventariosEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bodegas {
    private Integer idBodega;
    private String nombre;
    private String direccion;
    private String telefono;
    private Boolean estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Inventarios> inventarios;
    private List<MovimientosInventario> movimientosOrigen;
    private List<MovimientosInventario> movimientosDestino;

    public Bodegas(Integer idBodega, String nombre, String direccion,
                   String telefono, Boolean estado, LocalDateTime createdAt,
                   LocalDateTime updatedAt) {
        this.idBodega = idBodega;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.inventarios = new ArrayList<>();
        this.movimientosOrigen = new ArrayList<>();
        this.movimientosDestino = new ArrayList<>();
    }

    // Getters
    public Integer getIdBodega() { return idBodega; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public Boolean getEstado() { return estado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public List<Inventarios> getInventarios() { return new ArrayList<>(inventarios); }
    public List<MovimientosInventario> getMovimientosOrigen() { return new ArrayList<>(movimientosOrigen); }
    public List<MovimientosInventario> getMovimientosDestino() { return new ArrayList<>(movimientosDestino); }

    // Setters (solo para propiedades modificables)
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setEstado(Boolean estado) { this.estado = estado; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    // Métodos de negocio
    public void activar() {
        this.estado = true;
        this.updatedAt = LocalDateTime.now();
    }

    public void desactivar() {
        this.estado = false;
        this.updatedAt = LocalDateTime.now();
    }

    public void agregarInventario(Inventarios inventario) {
        this.inventarios.add(inventario);
    }

    public void agregarMovimientoOrigen(MovimientosInventario movimiento) {
        this.movimientosOrigen.add(movimiento);
    }

    public void agregarMovimientoDestino(MovimientosInventario movimiento) {
        this.movimientosDestino.add(movimiento);
    }
}