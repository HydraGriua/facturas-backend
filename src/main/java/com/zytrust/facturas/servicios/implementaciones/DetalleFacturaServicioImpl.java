/*
 * @(#)DetalleFacturaServicioImpl.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.servicios.implementaciones;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zytrust.facturas.dtos.detalle.CreateDetalleFacturaDto;
import com.zytrust.facturas.dtos.detalle.DetalleFacturaDto;
import com.zytrust.facturas.modelos.DetalleFactura;
import com.zytrust.facturas.modelos.Factura;
import com.zytrust.facturas.modelos.Producto;
import com.zytrust.facturas.repositorios.DetalleFacturaRepositorio;
import com.zytrust.facturas.repositorios.FacturaRepositorio;
import com.zytrust.facturas.repositorios.ProductoRepositorio;
import com.zytrust.facturas.servicios.DetalleFacturaServicio;
import com.zytrust.facturas.utiles.ConvertidorDto;

/**
 * Esta clase representa a una implementacion de la interfaz
 * DetalleFacturaServicio y debe ser
 * usada para realizar
 * logica de negocio y realizar intercambio de Data con repositorios y
 * controladores
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Service
public class DetalleFacturaServicioImpl implements DetalleFacturaServicio {

    /** Repositorio de factura con inyeccion de dependencia */
    @Autowired
    FacturaRepositorio facturaRepositorio;

    /** Repositorio de producto con inyeccion de dependencia */
    @Autowired
    ProductoRepositorio productoRepositorio;

    /** Repositorio de detalle de factura con inyeccion de dependencia */
    @Autowired
    DetalleFacturaRepositorio detalleFacturaRepositorio;

    /** convertidor de entidades a Dto con inyeccion de dependencia */
    @Autowired
    private ConvertidorDto converter;

    /**
     * Permite obtener todos los detalles de facturas y mapearlos a una lista de Dto
     *
     * @return Retorna una lista dto de todos los detalles de facturas
     */
    @Override
    @Transactional(readOnly = true)
    public List<DetalleFacturaDto> getAll() {
        return converter.detalleFacturaToDto(detalleFacturaRepositorio.findAll());
    }

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
    @Override
    @Transactional(readOnly = true)
    public List<DetalleFacturaDto> getAllByFacturaId(String facturaId) throws Exception {
        if (!facturaRepositorio.existsById(facturaId)) {
            throw new Exception("No se encontro Factura con id:" + facturaId);
        }
        return converter.detalleFacturaToDto(detalleFacturaRepositorio
                .findAllByFacturaFacturaId(facturaId));
    }

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
    @Override
    @Transactional(readOnly = true)
    public DetalleFacturaDto getDetalleFactura(String facturaId, String productoId) throws Exception {
        return converter.detalleFacturaToDto(detalleFacturaRepositorio
                .findDetalleFactura(facturaId, productoId)
                .orElseThrow(() -> new Exception("No se encontro Detalle de Factura con Factura Id:"
                        + facturaId + "y Producto Id:" + productoId)));
    }

    /**
     * Permite crear un nuevo detalle de factura
     *
     * @param detalle Dto de creacion para detalle
     * @return Retorna un objeto de tipo DetalleFacturaDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion de la factura
     *                   o error en la obtencion del producto
     */
    @Override
    @Transactional
    public DetalleFacturaDto createDetalleFactura(CreateDetalleFacturaDto detalle) throws Exception {
        Factura factura = facturaRepositorio.findById(detalle.getFacturaId())
                .orElseThrow(() -> new Exception("No se encontro Factura con id:"
                        + detalle.getFacturaId()));

        Producto producto = productoRepositorio.findById(detalle.getProductoId())
                .orElseThrow(() -> new Exception("No se encontro Producto con id:"
                        + detalle.getProductoId()));

        DetalleFactura detalleFactura = DetalleFactura.builder()
                .factura(factura)
                .producto(producto)
                .cantidad(detalle.getCantidad())
                .importe(producto.getPrecioUnitario().multiply(detalle.getCantidad()))
                .build();

        /* TODO: Mejorar la logica o confirmar */
        DetalleFactura detalleFacturaBD = detalleFacturaRepositorio.save(detalleFactura);
        factura.setSubtotal(factura.getSubtotal().add(detalleFacturaBD.getImporte()));
        factura.setImpuesto(factura.getSubtotal().multiply(new BigDecimal("0.18")));
        factura.setTotal(factura.getSubtotal().add(factura.getImpuesto()));

        facturaRepositorio.save(factura);

        return converter.detalleFacturaToDto(detalleFacturaBD);
    }
}
