/*
 * @(#)ClienteServicio.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.servicios;

import java.util.List;
import com.zytrust.facturas.dtos.cliente.ClienteDto;
import com.zytrust.facturas.dtos.cliente.CreateClienteDto;

/**
 * Esta interfaz representa a un servicio para cliente y debe ser usada para ser
 * la interfaz de la clase servicio implementada.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

public interface ClienteServicio {

    /**
     * Permite obtener todos los clientes y mapearlos a una lista de Dto
     *
     * @return Retorna una lista dto de todos los clientes
     */
    List<ClienteDto> getAll();

    /**
     * Permite la obtencion de un cliente segun el identificador de cliente
     *
     * @param id Identificador de cliente
     * @return Retorna un objeto de tipo ClienteDto
     */
    ClienteDto getCliente(String id);

    /**
     * Permite crear un nuevo cliente
     *
     * @param cliente Dto de creacion para cliente
     * @return Retorna un objeto de tipo ClienteDto
     */
    ClienteDto createCliente(CreateClienteDto cliente);
}
