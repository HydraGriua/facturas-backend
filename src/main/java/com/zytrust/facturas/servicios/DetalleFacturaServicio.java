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

import java.util.List;
import com.zytrust.facturas.dtos.detalle.CreateDetalleFacturaDto;
import com.zytrust.facturas.dtos.detalle.DetalleFacturaDto;

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
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion de la factura
     */
    List<DetalleFacturaDto> getAllByFacturaId(String facturaId) throws Exception;

    /**
     * Permite la obtencion de un detalle de factura segun el identificador de
     * factura
     * y el identificador de producto
     *
     * @param facturaId  Identificador de factura
     * @param productoId Identificador de producto
     * @return Retorna un objeto de tipo DetalleFacturaDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion de la factura
     *                   o error en la obtencion del producto
     */
    DetalleFacturaDto getDetalleFactura(String facturaId, String productoId) throws Exception;

    /**
     * Permite crear un nuevo detalle de factura
     *
     * @param detalle Dto de creacion para detalle
     * @return Retorna un objeto de tipo DetalleFacturaDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion de la factura
     *                   o error en la obtencion del producto
     */
    DetalleFacturaDto createDetalleFactura(CreateDetalleFacturaDto detalle) throws Exception;
}
