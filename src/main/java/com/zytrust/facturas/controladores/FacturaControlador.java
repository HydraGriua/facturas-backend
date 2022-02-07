/*
 * @(#)FacturaControlador.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.controladores;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.zytrust.facturas.dtos.ApiResponse;
import com.zytrust.facturas.dtos.Factura.CreateFacturaDto;
import com.zytrust.facturas.dtos.Factura.FacturaDto;
import com.zytrust.facturas.servicios.FacturaServicio;

/**
 * Esta clase representa a un controlador de factura y debe ser
 * usada para realizar
 * peticiones HTTP y proveer data del API.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@RestController
@RequestMapping("/facturas")
public class FacturaControlador {

    /** Servicio de factura con inyeccion de dependencia */
    @Autowired
    FacturaServicio facturaServicio;

    /**
     * Permite obtener todas las facturas
     *
     * @return Retorna un ApiResponse conteniendo la lista dto de todas las facturas
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ApiResponse<List<FacturaDto>> getAllFacturas() {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                facturaServicio.getAll());
    }

    /**
     * Permite obtener todas las facturas segun identificador de cliente
     *
     * @return Retorna un ApiResponse conteniendo la lista dto de todas las facturas de un cliente
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ApiResponse<List<FacturaDto>> getAllFacturasByClienteId(String clienteId) {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                facturaServicio.getAllByClienteId(clienteId));
    }

    /**
     * Permite crear una nueva factura
     *
     * @param factura Dto de creacion para factura
     * @return Retorna un ApiResponse conteniendo un objeto de tipo FacturaDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion del cliente
     */
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ApiResponse<FacturaDto> createFactura(@RequestBody @Valid CreateFacturaDto factura) throws Exception {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                facturaServicio.createFactura(factura));
    }
}
