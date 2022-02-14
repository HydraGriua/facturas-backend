/*
 * @(#)DetalleFacturaServicio.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.servicios;

import java.math.BigDecimal;
import java.util.List;
import com.zytrust.facturas.dtos.detalle.CreateDetalleSimpleDto;
import com.zytrust.facturas.dtos.detalle.DetalleFacturaDto;
import com.zytrust.facturas.modelos.DTOS.DetalleFacturaDTO;
import com.zytrust.facturas.modelos.Factura;

/**
 * Esta interfaz representa a un servicio para detalle de factura y debe ser
 * usada para ser
 * la interfaz de la clase servicio implementada.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

public interface DetalleFacturaServicio {

    /**
     * Permite obtener todos los detalles de facturas y mapearlos a una lista de Dto
     *
     * @return Retorna una lista dto de todos los detalles de facturas
     */
    List<DetalleFacturaDto> getAll();

    /**
     * Permite obtener todos los detalles de facturas segun el identificador de
     * factura
     * y mapearlos a una lista de Dto
     *
     * @param facturaId Identificador de factura
     * @return Retorna una lista dto de todos los detalles de una factura
     */
    List<DetalleFacturaDto> getAllByFacturaId(String facturaId);

    /**
     * Permite la obtencion de un detalle de factura segun el identificador de
     * factura
     * y el identificador de producto
     *
     * @param facturaId  Identificador de factura
     * @param productoId Identificador de producto
     * @return Retorna un objeto de tipo DetalleFacturaDto
     */
    DetalleFacturaDto getDetalleFactura(String facturaId, String productoId);

    /**
     * Permite crear un nuevo detalle de factura
     *
     * @param factura Objeto factura que se asignara al detalla
     * @param detalles Lista dto simple de detalles a procesar
     * @return Retorna un objeto de tipo DetalleFacturaDto
     */
    BigDecimal createDetalleFactura(Factura factura, CreateDetalleSimpleDto[] detalles);

    /**
     * Permite obtener una lista dto de todos los detalles de facturas segun el
     * identificador de factura
     *
     * @param facturaId Identificador de factura
     * @return Retorna una lista dto de todos los detalles de una factura
     */
    List<DetalleFacturaDTO> findAllDetalleFacturaDTOByFacturaId(String facturaId);
}
