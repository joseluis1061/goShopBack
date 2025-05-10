package com.jlzDev.goShop.persistence.mapper;

import com.jlzDev.goShop.domain.model.Bodegas;
import com.jlzDev.goShop.persistence.entity.BodegasEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Interfaz que define los métodos de mapeo entre BodegasEntity y Bodegas.
 * Utiliza MapStruct para la implementación automática de estos métodos.
 */
/*
@Mapper(
        componentModel = "spring",
        uses = {
                InventariosMapper.class,
                MovimientosInventarioMapper.class
        }
)

*/
public interface BodegasMapper {

    /**
     * Convierte una entidad de BodegasEntity a un modelo de dominio Bodegas
     * @param bodegasEntity La entidad de bodegas proveniente de la base de datos
     * @return El modelo de dominio Bodegas
     */

/*
    @Mappings({
            @Mapping(source = "idBodega", target = "idBodega"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "direccion", target = "direccion"),
            @Mapping(source = "telefono", target = "telefono"),
            @Mapping(source = "estado", target = "estado"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "updatedAt", target = "updatedAt"),
            @Mapping(source = "inventarios", target = "inventarios"),
            @Mapping(source = "movimientosOrigen", target = "movimientosOrigen"),
            @Mapping(source = "movimientosDestino", target = "movimientosDestino")
    })
    Bodegas toBodegas(BodegasEntity bodegasEntity);

    /**
     * Convierte un modelo de dominio Bodegas a una entidad de BodegasEntity
     * @param bodegas El modelo de dominio Bodegas
     * @return La entidad de Bodegas para persistir en base de datos
     */

    /*
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "inventarios", ignore = true),
            @Mapping(target = "movimientosOrigen", ignore = true),
            @Mapping(target = "movimientosDestino", ignore = true)
    })
    BodegasEntity toBodegasEntity(Bodegas bodegas);

    /**
     * Convierte una lista de entidades a una lista de modelos de dominio
     * @param bodegasEntities Lista de entidades BodegasEntity
     * @return Lista de modelos de dominio Bodegas
     */
    /*
    List<Bodegas> toBodegasList(List<BodegasEntity> bodegasEntities);

    /**
     * Convierte una lista de modelos de dominio a una lista de entidades
     * @param bodegas Lista de modelos de dominio Bodegas
     * @return Lista de entidades BodegasEntity para persistir
     */
    //List<BodegasEntity> toBodegasEntityList(List<Bodegas> bodegas);
}