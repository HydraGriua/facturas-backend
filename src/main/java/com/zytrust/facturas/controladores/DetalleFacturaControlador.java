/*
 * @(#)DetalleFacturaControlador.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.zytrust.facturas.dtos.ApiResponse;
import com.zytrust.facturas.dtos.detalle.DetalleFacturaDto;
import com.zytrust.facturas.servicios.DetalleFacturaServicio;

/**
 * Esta clase representa a un controlador de detalle de factura y debe ser
 * usada para realizar
 * peticiones HTTP y proveer data del API.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@RestController
@RequestMapping()
public class DetalleFacturaControlador {

    /** Servicio de detalle de factura con inyeccion de dependencia */
    @Autowired
    DetalleFacturaServicio detalleFacturaServicio;

    /**
     * Permite obtener todos los detalles de facturas
     *
     * @return Retorna un ApiResponse conteniendo la lista dto de todos los detalles
     *         de facturas
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detalles")
    public ApiResponse<List<DetalleFacturaDto>> getAllDetalleFactura() {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                detalleFacturaServicio.getAll());
    }

    /**
     * Permite obtener todos los detalles de facturas segun el identificador de
     * factura
     *
     * @param facturaId Identificador de factura
     * @return Retorna un ApiResponse conteniendo la lista dto de todos los detalles
     *         de una factura
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion de la factura
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/facturas/{facturaId}/detalles")
    public ApiResponse<List<DetalleFacturaDto>> getAllDetalleFacturaByFacturaId(
            @PathVariable String facturaId) throws Exception {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                detalleFacturaServicio.getAllByFacturaId(facturaId));
    }
}
