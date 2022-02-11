/*
 * @(#)FacturaRepositorio.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.repositorios;

import java.util.List;

import com.zytrust.facturas.modelos.DTOS.FacturaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.zytrust.facturas.modelos.Factura;

/**
 * Esta interfaz representa a un respositorio para factura y debe ser usada para
 * realizar consultas a la base de datos e intercambiar datos con servicios.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, String> {

    /**
     * Permite obtener todos las facturas segun el identificador de cliente
     *
     * @param clienteId Identificador de cliente
     * @return Retorna una lista de facturas por cliente
     */
    List<Factura> findAllByClienteClienteId(String clienteId);

    @Query(value = "SELECT f.facturaId AS codFactura, f.direccion AS direccion,"
            +" f.fechaHoraEmision AS fechaHoraEmision, f.fechaHoraPago"
            +" AS fechaHoraPago, COALESCE(f.tipoPago,'---') AS tipoPago, CASE WHEN "
            +"(f.estado = 'i') THEN 'ingresada' WHEN (f.estado = 'c') THEN 'confirmada' "
            +"ELSE 'ANULADA' END AS estado, f.subtotal AS subtotal, f.impuesto "
            +"AS impuesto, f.total AS total, f.cliente.clienteId AS codCliente, "
            +"(SELECT COUNT(df) from DetalleFactura df WHERE df.facturaId = f.facturaId)"
            +" AS numProductos FROM Factura f GROUP BY f")
    List<FacturaDTO> findAllFacturaDTO();
}
