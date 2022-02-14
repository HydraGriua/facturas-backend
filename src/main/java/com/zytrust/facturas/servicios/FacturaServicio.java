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
import com.zytrust.facturas.dtos.Factura.FacturaCompletaDto;
import com.zytrust.facturas.dtos.Factura.FacturaDto;
import com.zytrust.facturas.modelos.DTOS.FacturaDTO;

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
     * Permite obtener todos las facturas segun identificador de cliente y mapearlas a una lista de Dto
     * @param clienteId
     * @return Retorna una lista dto de todas las facturas de un cliente
     */
    List<FacturaDto> getAllByClienteId(String clienteId);

    /**
     * Permite la obtencion de una factura segun el identificador de factura
     *
     * @param id Identificador de factura
     * @return Retorna un objeto de tipo FacturaDto
     */
    FacturaDto getFactura(String id);

    /**
     * Permite crear una nueva factura
     *
     * @param factura Dto de creacion para factura
     * @return Retorna un objeto de tipo FacturaDto
     */
    FacturaDto createFactura(CreateFacturaDto factura);

    /**
     * Permite crear una nueva factura junto con sus detalles
     *
     * @param factura Dto completo de creacion para factura
     * @return Retorna un objeto de tipo FacturaDto
     */
    FacturaDto createFacturaCompleta(FacturaCompletaDto factura);

    /**
     * Permite actualizar el estado de una factura
     *
     * @param estado    Caracter que representa el nuevo estado
     * @param facturaId Identificador de factura
     * @return Retorna un objeto de tipo FacturaDto
     */
    FacturaDto updateEstadoFactura(Character estado, String facturaId);

    /**
     * Permite agregar informacion para el pago de una factura
     *
     * @param tipoPago  String que representa el tipo de pago a usar
     * @param facturaId Identificador de factura
     * @return Retorna un objeto de tipo FacturaDto
     */
    FacturaDto pagoFactura(String tipoPago, String facturaId);

    /**
     * Permite obtener una lista de todas las facturas en formato DTO
     * @return Retorna una lista dto de todas las facturas
     */
    List<FacturaDTO> findAllFacturaDTO();

    /**
     * Permite obtener una lista de todas las facturas segun identificador de
     * cliente en formato DTO
     * @param clienteId Identificador de cliente
     * @return Retorna una lista dto de todas las facturas
     */
    List<FacturaDTO> findAllFacturaDTOByClienteId(String clienteId);

    /**
     * Permite obtener una lista de todas las facturas segun identificador de
     * factura en formato DTO
     * @param facturaId Identificador de factura
     * @return Retorna un dto de factura
     */
    FacturaDTO findFacturaDTO(String facturaId);
}
