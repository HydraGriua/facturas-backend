/*
 * @(#)DetalleFacturaRepositorio.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.repositorios;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.zytrust.facturas.modelos.DetalleFactura;

/**
 * Esta interfaz representa a un respositorio para cliente y debe ser usada para realizar
 * consultas a la base de datos e intercambiar datos con servicios.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Repository
public interface DetalleFacturaRepositorio extends JpaRepository<DetalleFactura,String> {

    /**
     * Permite obtener todos los detalles segun el identificador de factura
     * @param facturaId Identificador de factura
     * @return Retorna una lista de detalles de la factura
     */
    List<DetalleFactura> findAllByFacturaFacturaId(String facturaId);

    /**
     * Permite obtener un detalle de factura segun el identificador de factura
     * y el identificador de producto
     * @param facturaId Identificador de factura
     * @param productoId Identificador de producto
     * @return Retorna un detalle de factura
     */
    @Query("SELECT df FROM DetalleFactura df WHERE df.factura.facturaId = :facturaId AND df.producto.productoId = :productoId")
    Optional<DetalleFactura> findDetalleFactura(@Param("facturaId") String facturaId, @Param("productoId") String productoId);
}
