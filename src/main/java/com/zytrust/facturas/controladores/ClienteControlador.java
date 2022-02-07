/*
 * @(#)ClienteControlador.java
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
import com.zytrust.facturas.dtos.cliente.ClienteDto;
import com.zytrust.facturas.dtos.cliente.CreateClienteDto;
import com.zytrust.facturas.servicios.ClienteServicio;

/**
 * Esta clase representa a un controlador de cliente y debe ser
 * usada para realizar
 * peticiones HTTP y proveer data del API.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

    /** Servicio de cliente con inyeccion de dependencia */
    @Autowired
    ClienteServicio clienteServicio;

    /**
     * Permite obtener todos los clientes
     *
     * @return Retorna un ApiResponse conteniendo la lista dto de todos los clientes
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ApiResponse<List<ClienteDto>> getAllClientes() {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                clienteServicio.getAll());
    }

    /**
     * Permite crear un cliente
     *
     * @param cliente Dto de creacion para cliente
     * @return Retorna un ApiResponse conteniendo un Objeto de tipo ClienteDto
     */
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ApiResponse<ClienteDto> createCliente(
            @RequestBody @Valid CreateClienteDto cliente) {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                clienteServicio.createCliente(cliente));
    }
}
