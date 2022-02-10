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
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zytrust.facturas.dtos.detalle.CreateDetalleSimpleDto;
import com.zytrust.facturas.dtos.detalle.DetalleFacturaDto;
import com.zytrust.facturas.excepciones.FacturasException;
import com.zytrust.facturas.modelos.DetalleFactura;
import com.zytrust.facturas.modelos.Factura;
import com.zytrust.facturas.modelos.Producto;
import com.zytrust.facturas.repositorios.DetalleFacturaRepositorio;
import com.zytrust.facturas.repositorios.FacturaRepositorio;
import com.zytrust.facturas.repositorios.ProductoRepositorio;
import com.zytrust.facturas.servicios.DetalleFacturaServicio;
import com.zytrust.facturas.utiles.CodigoError;
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
    public List<DetalleFacturaDto> getAllByFacturaId(String facturaId) {
        if (!facturaRepositorio.existsById(facturaId)) {
            throw new FacturasException(CodigoError.FACTURA_NO_EXISTE);
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
     */
    @Override
    @Transactional(readOnly = true)
    public DetalleFacturaDto getDetalleFactura(String facturaId, String productoId) {
        Optional<DetalleFactura> opt = detalleFacturaRepositorio
                .findDetalleFactura(facturaId, productoId);
        if (opt.isEmpty()) {
            throw new FacturasException(CodigoError.DETALLE_FACTURA_NO_EXISTE);
        }
        return converter.detalleFacturaToDto(opt.get());
    }

    /**
     * Permite crear un nuevo detalle de factura
     *
     * @param detalle Dto de creacion para detalle
     * @return Retorna un objeto de tipo DetalleFacturaDto
     */
    @Override
    @Transactional
    public BigDecimal createDetalleFactura(Factura factura, CreateDetalleSimpleDto[] detalles) {

        BigDecimal subtotal = new BigDecimal("0.00");
        for (CreateDetalleSimpleDto detalle : detalles) {

            Optional<Producto> opt = productoRepositorio.findById(detalle.getProductoId());

            if (opt.isEmpty()) {
                throw new FacturasException(CodigoError.PRODUCTO_NO_EXISTE);
            }

            Producto producto = opt.get();

            DetalleFactura detalleFactura = DetalleFactura.builder()
                    .factura(factura)
                    .producto(producto)
                    .facturaId(factura.getFacturaId())
                    .productoId(producto.getProductoId())
                    .cantidad(detalle.getCantidad())
                    .importe(producto.getPrecioUnitario().multiply(detalle.getCantidad()))
                    .build();

            detalleFacturaRepositorio.save(detalleFactura);
            subtotal = subtotal.add(detalleFactura.getImporte()).stripTrailingZeros();
        }
        return subtotal;
    }
}
