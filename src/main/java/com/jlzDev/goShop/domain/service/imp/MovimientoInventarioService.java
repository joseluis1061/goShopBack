package com.jlzDev.goShop.domain.service.imp;

import com.jlzDev.goShop.domain.repository.MovimientoInventarioRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class MovimientoInventarioService implements MovimientoInventarioRepository {


    @Override
    public List<Object> getAll() {
        return List.of();
    }

    @Override
    public Optional<Object> getMovimiento(int movimientoId) {
        return Optional.empty();
    }

    @Override
    public List<Object> getByBodegaOrigen(int bodegaId) {
        return List.of();
    }

    @Override
    public List<Object> getByBodegaDestino(int bodegaId) {
        return List.of();
    }

    @Override
    public List<Object> getByPuntoVentaOrigen(int puntoVentaId) {
        return List.of();
    }

    @Override
    public List<Object> getByPuntoVentaDestino(int puntoVentaId) {
        return List.of();
    }

    @Override
    public List<Object> getByTipoMovimiento(String tipoMovimiento) {
        return List.of();
    }

    @Override
    public List<Object> getByEstado(String estado) {
        return List.of();
    }

    @Override
    public List<Object> getByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return List.of();
    }

    @Override
    public Object save(Object movimiento) {
        return null;
    }

    @Override
    public boolean updateEstado(int movimientoId, String nuevoEstado) {
        return false;
    }

    @Override
    public boolean ejecutarMovimiento(int movimientoId) {
        return false;
    }

    @Override
    public boolean delete(int movimientoId) {
        return false;
    }
}
    /*
    private final MovimientosInventarioCrudRepository movimientosInventarioCrudRepository;

    @Autowired
    public MovimientoInventarioRepositoryImpl(MovimientosInventarioCrudRepository movimientosInventarioCrudRepository) {
        this.movimientosInventarioCrudRepository = movimientosInventarioCrudRepository;
    }

    @Override
    public List<Object> getAll() {
        List<MovimientosInventario> movimientos = movimientosInventarioCrudRepository.findAll();
        return movimientos.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<Object> getMovimiento(int movimientoId) {
        return movimientosInventarioCrudRepository.findById(movimientoId).map(this::mapToDTO);
    }

    @Override
    public List<Object> getByBodegaOrigen(int bodegaId) {
        List<MovimientosInventario> movimientos = movimientosInventarioCrudRepository.findByBodegaOrigen(new Bodegas(bodegaId));
        return movimientos.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<Object> getByBodegaDestino(int bodegaId) {
        List<MovimientosInventario> movimientos = movimientosInventarioCrudRepository.findByBodegaDestino(new Bodegas(bodegaId));
        return movimientos.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<Object> getByPuntoVentaDestino(int puntoVentaId) {
        List<MovimientosInventario> movimientos = movimientosInventarioCrudRepository.findByPuntoVentaDestino(new PuntosVenta(puntoVentaId));
        return movimientos.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<Object> getByPuntoVentaOrigen(int puntoVentaId) {
        List<MovimientosInventario> movimientos = movimientosInventarioCrudRepository.findByPuntoVentaOrigen(new PuntosVenta(puntoVentaId));
        return movimientos.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<Object> getByTipoMovimiento(String tipoMovimiento) {
        List<MovimientosInventario> movimientos = movimientosInventarioCrudRepository.findByTipoMovimiento(TipoMovimiento.valueOf(tipoMovimiento));
        return movimientos.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<Object> getByEstado(String estado) {
        List<MovimientosInventario> movimientos = movimientosInventarioCrudRepository.findByEstado(EstadoMovimiento.valueOf(estado));
        return movimientos.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<Object> getByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        List<MovimientosInventario> movimientos = movimientosInventarioCrudRepository.findByFechaBetween(fechaInicio, fechaFin);
        return movimientos.stream().map(this::mapToDTO).collect(Collectors.toList());
    }


    @Override
    public Object save(Object movimiento) {
        MovimientoInventarioDTO dto = (MovimientoInventarioDTO) movimiento;
        MovimientosInventario entity = mapToEntity(dto);
        MovimientosInventario saved = movimientosInventarioCrudRepository.save(entity);
        return mapToDTO(saved);
    }

    @Override
    public boolean updateEstado(int movimientoId, String nuevoEstado) {
        Optional<MovimientosInventario> optional = movimientosInventarioCrudRepository.findById(movimientoId);
        if (optional.isPresent()) {
            MovimientosInventario movimiento = optional.get();
            movimiento.setEstado(EstadoMovimiento.valueOf(nuevoEstado));
            movimientosInventarioCrudRepository.save(movimiento);
            return true;
        }
        return false;
    }

    @Override
    public boolean ejecutarMovimiento(int movimientoId) {
        // Aquí se implementaría la lógica de ejecución del movimiento.
        return false;
    }

    @Override
    public boolean delete(int movimientoId) {
        if (movimientosInventarioCrudRepository.existsById(movimientoId)) {
            movimientosInventarioCrudRepository.deleteById(movimientoId);
            return true;
        }
        return false;
    }

    private MovimientoInventarioDTO mapToDTO(MovimientosInventario entity) {
        MovimientoInventarioDTO dto = new MovimientoInventarioDTO();
        dto.setIdMovimiento(entity.getIdMovimiento());
        dto.setFecha(entity.getFecha());
        dto.setTipoMovimiento(entity.getTipoMovimiento().name());
        dto.setEstado(entity.getEstado().name());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        if (entity.getBodegaOrigen() != null) {
            dto.setIdBodegaOrigen(entity.getBodegaOrigen().getIdBodega());
            dto.setNombreBodegaOrigen(entity.getBodegaOrigen().getNombre());
        }
        if (entity.getBodegaDestino() != null) {
            dto.setIdBodegaDestino(entity.getBodegaDestino().getIdBodega());
            dto.setNombreBodegaDestino(entity.getBodegaDestino().getNombre());
        }
        if (entity.getPuntoVentaOrigen() != null) {
            dto.setIdPuntoVentaOrigen(entity.getPuntoVentaOrigen().getIdPuntoVenta());
            dto.setNombrePuntoVentaOrigen(entity.getPuntoVentaOrigen().getNombre());
        }
        if (entity.getPuntoVentaDestino() != null) {
            dto.setIdPuntoVentaDestino(entity.getPuntoVentaDestino().getIdPuntoVenta());
            dto.setNombrePuntoVentaDestino(entity.getPuntoVentaDestino().getNombre());
        }

        // Detalles se puede mapear si hay DTO y entidad disponibles

        return dto;
    }
    */

    /*
    private MovimientosInventario mapToEntity(MovimientoInventarioDTO dto) {
        MovimientosInventario entity = new MovimientosInventario();
        entity.setIdMovimiento(dto.getIdMovimiento());
        entity.setFecha(dto.getFecha());
        entity.setTipoMovimiento(TipoMovimiento.valueOf(dto.getTipoMovimiento()));
        entity.setEstado(EstadoMovimiento.valueOf(dto.getEstado()));
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());

        if (dto.getIdBodegaOrigen() != null) entity.setBodegaOrigen(new Bodegas(dto.getIdBodegaOrigen()));
        if (dto.getIdBodegaDestino() != null) entity.setBodegaDestino(new Bodegas(dto.getIdBodegaDestino()));
        if (dto.getIdPuntoVentaOrigen() != null) entity.setPuntoVentaOrigen(new PuntosVenta(dto.getIdPuntoVentaOrigen()));
        if (dto.getIdPuntoVentaDestino() != null) entity.setPuntoVentaDestino(new PuntosVenta(dto.getIdPuntoVentaDestino()));

        // Detalles se puede mapear si hay DTO y entidad disponibles

        return entity;
    }
    */