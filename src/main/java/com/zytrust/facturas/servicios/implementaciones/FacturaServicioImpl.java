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
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zytrust.facturas.dtos.Factura.CreateFacturaDto;
import com.zytrust.facturas.dtos.Factura.FacturaCompletaDto;
import com.zytrust.facturas.dtos.Factura.FacturaDto;
import com.zytrust.facturas.excepciones.FacturasException;
import com.zytrust.facturas.modelos.Cliente;
import com.zytrust.facturas.modelos.Factura;
import com.zytrust.facturas.repositorios.ClienteRepositorio;
import com.zytrust.facturas.repositorios.FacturaRepositorio;
import com.zytrust.facturas.servicios.DetalleFacturaServicio;
import com.zytrust.facturas.servicios.FacturaServicio;
import com.zytrust.facturas.utiles.CodigoError;
import com.zytrust.facturas.utiles.ConvertidorDto;

/**
 * Esta clase representa a una implementacion de la interfaz
 * FacturaServicio y debe ser
 * usada para realizar
 * logica de negocio y realizar intercambio de Data con repositorios y
 * controladores
 *
 * @author Flavio Saavedra Montenegro
 * @version 1.1, 08/02/2022
 */

@Service
public class FacturaServicioImpl implements FacturaServicio {

    /** Repositorio de factura con inyeccion de dependencia */
    @Autowired
    FacturaRepositorio facturaRepositorio;

    /** Repositorio de cliente con inyeccion de dependencia */
    @Autowired
    ClienteRepositorio clienteRepositorio;

    /** Repositorio de cliente con inyeccion de dependencia */
    @Autowired
    DetalleFacturaServicio detalleFacturaServicio;

    /** Logger de servicio */
    private static final Logger logger = LoggerFactory.getLogger(FacturaServicioImpl.class);

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
     * Permite obtener todos las facturas segun identificador de cliente y mapearlas
     * a una lista de Dto
     * 
     * @param clienteId
     * @return Retorna una lista dto de todas las facturas de un cliente
     */
    @Override
    public List<FacturaDto> getAllByClienteId(String clienteId) {
        return converter.facturaToDto(facturaRepositorio.findAllByClienteClienteId(clienteId));
    }

    /**
     * Permite la obtencion de una factura segun el identificador de factura
     *
     * @param id Identificador de factura
     * @return Retorna un objeto de tipo FacturaDto
     */
    @Override
    @Transactional(readOnly = true)
    public FacturaDto getFactura(String id) {

        Optional<Factura> opt = facturaRepositorio.findById(id);
        if (opt.isEmpty()) {
            logger.info("No se encontro la factura con el id {}", id);
            throw new FacturasException(CodigoError.FACTURA_NO_EXISTE);
        }
        return converter.facturaToDto(opt.get());
    }

    /**
     * Permite crear una nueva factura
     *
     * @param factura Dto de creacion para factura
     * @return Retorna un objeto de tipo FacturaDto
     */
    @Override
    @Transactional
    public FacturaDto createFactura(CreateFacturaDto factura) {

        Optional<Cliente> cliente = clienteRepositorio.findById(factura.getClienteId());

        if (cliente.isEmpty()) {
            logger.info("No se encontro el cliente con el id {}", factura.getClienteId());
            throw new FacturasException(CodigoError.CLIENTE_NO_EXISTE);
        }

        Factura facturaEntidad = Factura.builder()
                .cliente(cliente.get())
                .direccion(factura.getDireccion())
                .fechaHoraEmision(LocalDateTime.of(LocalDate.now(), LocalTime.now()))
                .estado('i')
                .subtotal(new BigDecimal("0"))
                .impuesto(new BigDecimal("0"))
                .total(new BigDecimal("0"))
                .build();

        facturaEntidad = facturaRepositorio.save(facturaEntidad);
        logger.debug("Se creo la factura {}", facturaEntidad.toString());

        return converter.facturaToDto(facturaEntidad);
    }

    /**
     * Permite crear una nueva factura junto con sus detalles
     *
     * @param factura Dto completo de creacion para factura
     * @return Retorna un objeto de tipo FacturaDto
     */
    @Override
    @Transactional
    public FacturaDto createFacturaCompleta(FacturaCompletaDto factura) {

        Optional<Cliente> cliente = clienteRepositorio.findById(factura.getClienteId());

        if (cliente.isEmpty()) {
            logger.info("No se encontro el cliente con el id {}", factura.getClienteId());
            throw new FacturasException(CodigoError.CLIENTE_NO_EXISTE);
        }

        Factura facturaEntidad = Factura.builder()
                .cliente(cliente.get())
                .direccion(factura.getDireccion())
                .fechaHoraEmision(LocalDateTime.of(LocalDate.now(), LocalTime.now()))
                .estado('i')
                .subtotal(new BigDecimal("0"))
                .impuesto(new BigDecimal("0"))
                .total(new BigDecimal("0"))
                .build();

        facturaEntidad = facturaRepositorio.save(facturaEntidad);
        logger.debug("Se creo la factura {}", facturaEntidad.toString());

        BigDecimal subtotal = detalleFacturaServicio.
        createDetalleFactura(facturaEntidad, factura.getDetalles());

        facturaEntidad.setSubtotal(facturaEntidad.getSubtotal()
                .add(subtotal));

        facturaEntidad.setImpuesto(facturaEntidad.getSubtotal()
                .multiply(new BigDecimal("0.18")));

        facturaEntidad.setTotal(facturaEntidad.getSubtotal()
                .add(facturaEntidad.getImpuesto()));

        facturaEntidad = facturaRepositorio.save(facturaEntidad);
        logger.debug("Se actualizo la factura {}", facturaEntidad.toString());

        return converter.facturaToDto(facturaEntidad);
    }

    /**
     * Permite actualizar el estado de una factura
     *
     * @param estado    Caracter que representa el nuevo estado
     * @param facturaId Identificador de factura
     * @return Retorna un objeto de tipo FacturaDto
     */
    @Override
    @Transactional
    public FacturaDto updateEstadoFactura(Character estado, String facturaId) {

        Optional<Factura> opt = facturaRepositorio.findById(facturaId);
        if (opt.isEmpty()) {
            logger.info("No se encontro la factura con el id {}", facturaId);
            throw new FacturasException(CodigoError.FACTURA_NO_EXISTE);
        }
        Factura factura = opt.get();
        factura.setEstado(estado);

        factura = facturaRepositorio.save(factura);
        logger.debug("Se creo la factura {}", factura.toString());

        return converter.facturaToDto(factura);
    }

    /**
     * Permite agregar informacion para el pago de una factura
     *
     * @param tipoPago  String que representa el tipo de pago a usar
     * @param facturaId Identificador de factura
     * @return Retorna un objeto de tipo FacturaDto
     */
    @Override
    public FacturaDto pagoFactura(String tipoPago, String facturaId) {

        Optional<Factura> opt = facturaRepositorio.findById(facturaId);

        if (opt.isEmpty()) {
            logger.info("No se encontro la factura con el id {}", facturaId);
            throw new FacturasException(CodigoError.FACTURA_NO_EXISTE);
        }

        Factura factura = opt.get();
        factura.setEstado('c');
        factura.setTipoPago(tipoPago);
        factura.setFechaHoraPago(LocalDateTime.of(LocalDate.now(), LocalTime.now()));

        factura = facturaRepositorio.save(factura);
        logger.debug("Se creo la factura {}", factura.toString());

        return converter.facturaToDto(factura);
    }

}
