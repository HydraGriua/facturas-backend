/*
 * @(#)FacturaServicio.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.servicios;

import java.util.List;
import com.zytrust.facturas.dtos.Factura.CreateFacturaDto;
import com.zytrust.facturas.dtos.Factura.FacturaDto;

/**
 * Esta interfaz representa a un servicio para factura y debe ser usada para ser
 * la interfaz de la clase servicio implementada.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

public interface FacturaServicio {

    /**
     * Permite obtener todos las facturas y mapearlas a una lista de Dto
     *
     * @return Retorna una lista dto de todas las facturas
     */
    List<FacturaDto> getAll();

    /**
     * Permite la obtencion de una factura segun el identificador de factura
     *
     * @param id Identificador de factura
     * @return Retorna un objeto de tipo FacturaDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion de la factura
     */
    FacturaDto getFactura(String id) throws Exception;

    /**
     * Permite crear una nueva factura
     *
     * @param factura Dto de creacion para factura
     * @return Retorna un objeto de tipo FacturaDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion del cliente
     */
    FacturaDto createFactura(CreateFacturaDto factura) throws Exception;

    /**
     * Permite actualizar el estado de una factura
     *
     * @param estado    Caracter que representa el nuevo estado
     * @param facturaId Identificador de factura
     * @return Retorna un objeto de tipo FacturaDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion de la factura
     */
    FacturaDto updateEstadoFactura(Character estado, String facturaId) throws Exception;

    /**
     * Permite agregar informacion para el pago de una factura
     *
     * @param tipoPago  String que representa el tipo de pago a usar
     * @param facturaId Identificador de factura
     * @return Retorna un objeto de tipo FacturaDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion de la factura
     */
    FacturaDto pagoFactura(String tipoPago, String facturaId) throws Exception;
}
