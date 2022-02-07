/*
 * @(#)FacturaServicioImpl.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.servicios.implementaciones;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zytrust.facturas.dtos.Factura.CreateFacturaDto;
import com.zytrust.facturas.dtos.Factura.FacturaDto;
import com.zytrust.facturas.modelos.Cliente;
import com.zytrust.facturas.modelos.Factura;
import com.zytrust.facturas.repositorios.ClienteRepositorio;
import com.zytrust.facturas.repositorios.FacturaRepositorio;
import com.zytrust.facturas.servicios.FacturaServicio;
import com.zytrust.facturas.utiles.ConvertidorDto;

/**
 * Esta clase representa a una implementacion de la interfaz
 * FacturaServicio y debe ser
 * usada para realizar
 * logica de negocio y realizar intercambio de Data con repositorios y
 * controladores
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Service
public class FacturaServicioImpl implements FacturaServicio {

    /** Repositorio de factura con inyeccion de dependencia */
    @Autowired
    FacturaRepositorio facturaRepositorio;

    /** Repositorio de cliente con inyeccion de dependencia */
    @Autowired
    ClienteRepositorio clienteRepositorio;

    /** convertidor de entidades a Dto con inyeccion de dependencia */
    @Autowired
    private ConvertidorDto converter;

    /**
     * Permite obtener todos las facturas y mapearlas a una lista de Dto
     *
     * @return Retorna una lista dto de todas las facturas
     */
    @Override
    @Transactional(readOnly = true)
    public List<FacturaDto> getAll() {
        return converter.facturaToDto(facturaRepositorio.findAll());
    }

    /**
     * Permite obtener todos las facturas segun identificador de cliente y mapearlas a una lista de Dto
     * @param clienteId
     * @return Retorna una lista dto de todas las facturas de un cliente
     */
    @Override
    public List<FacturaDto> getAllByClienteId(String clienteId) {
        return converter.facturaToDto(facturaRepositorio.findAllByClienteclienteId(clienteId));
    }

    /**
     * Permite la obtencion de una factura segun el identificador de factura
     *
     * @param id Identificador de factura
     * @return Retorna un objeto de tipo FacturaDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion de la factura
     */
    @Override
    @Transactional(readOnly = true)
    public FacturaDto getFactura(String id) throws Exception {
        return converter.facturaToDto(facturaRepositorio.findById(id)
                .orElseThrow(() -> new Exception("No se encontro Factura con id:" + id)));
    }

    /**
     * Permite crear una nueva factura
     *
     * @param factura Dto de creacion para factura
     * @return Retorna un objeto de tipo FacturaDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion del cliente
     */
    @Override
    @Transactional
    public FacturaDto createFactura(CreateFacturaDto factura) throws Exception {

        Cliente cliente = clienteRepositorio.findById(factura.getClienteId())
                .orElseThrow(() -> new Exception("No se encontro Cliente con id:"
                + factura.getClienteId()));

        LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.now();
        LocalDateTime fecha = LocalDateTime.of(hoy, ahora);

        Factura facturaEntidad = Factura.builder()
                .cliente(cliente)
                .direccion(factura.getDireccion())
                .fechaHoraEmision(fecha)
                .estado('i')
                .subtotal(new BigDecimal("0"))
                .impuesto(new BigDecimal("0"))
                .total(new BigDecimal("0"))
                .build();

        return converter.facturaToDto(facturaRepositorio.save(facturaEntidad));
    }

    /**
     * Permite actualizar el estado de una factura
     *
     * @param estado    Caracter que representa el nuevo estado
     * @param facturaId Identificador de factura
     * @return Retorna un objeto de tipo FacturaDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion de la factura
     */
    @Override
    public FacturaDto updateEstadoFactura(Character estado, String facturaId) throws Exception {
        Factura factura = facturaRepositorio.findById(facturaId)
                .orElseThrow(() -> new Exception("No se encontro Factura con id:"
                + facturaId));

        factura.setEstado(estado);

        return converter.facturaToDto(facturaRepositorio.save(factura));
    }

    /**
     * Permite agregar informacion para el pago de una factura
     *
     * @param tipoPago  String que representa el tipo de pago a usar
     * @param facturaId Identificador de factura
     * @return Retorna un objeto de tipo FacturaDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion de la factura
     */
    @Override
    public FacturaDto pagoFactura(String tipoPago, String facturaId) throws Exception {
        Factura factura = facturaRepositorio.findById(facturaId)
                .orElseThrow(() -> new Exception("No se encontro Factura con id:"
                + facturaId));

        factura.setEstado('c');
        factura.setTipoPago(tipoPago);

        LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.now();
        LocalDateTime fecha = LocalDateTime.of(hoy, ahora);
        factura.setFechaHoraPago(fecha);

        return converter.facturaToDto(facturaRepositorio.save(factura));
    }

}
