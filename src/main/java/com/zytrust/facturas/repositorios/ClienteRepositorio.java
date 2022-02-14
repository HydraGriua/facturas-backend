/*
 * @(#)ClienteRepositorio.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.zytrust.facturas.modelos.Cliente;
import com.zytrust.facturas.modelos.DTOS.ClienteDTO;

/**
 * Esta interfaz representa a un respositorio para cliente y debe ser usada para
 * realizar consultas a la base de datos e intercambiar datos con servicios.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String> {

    /**
    * Permite obtener todos los clientes en formato DTO
    *
    * @return Retorna una lista dto de todos los clientes
    */
    @Query(value = "SELECT cl.clienteId AS codCliente, cl.numDocumento AS nroDocumento,"
            + " cl.tipoDocumento AS tipoDocumento, cl.primerNombre AS nombre,"
            + " cl.primerApellido AS apellido, cl.fechaNacimiento AS fechaNacimiento,"
            + " cl.genero AS genero, cl.email AS email, cl.celular AS celular,"
            + " cl.direccion AS direccion, cl.nombreEmpresa AS nombreEmpresa, "
            + "(SELECT COUNT(f) from Factura f WHERE f.cliente.clienteId = cl.clienteId)"
            + " AS numFacturas FROM Cliente cl GROUP BY cl")
    List<ClienteDTO> findAllClienteDTO();

    /**
    * Permite obtener un cliente dto segun el identificador de cliente
    *
    * @param clienteId Identificador de cliente
    * @return Retorna un cliente en formato DTO
    */
    @Query(value = "SELECT cl.clienteId AS codCliente, cl.numDocumento AS nroDocumento, "
            + "cl.tipoDocumento AS tipoDocumento, cl.primerNombre AS nombre, "
            + "cl.primerApellido AS apellido, cl.fechaNacimiento AS fechaNacimiento, "
            + "cl.genero AS genero, cl.email AS email, cl.celular AS celular, "
            + "cl.direccion AS direccion, cl.nombreEmpresa AS nombreEmpresa, "
            + "(SELECT COUNT(f) from Factura f WHERE f.cliente.clienteId = cl.clienteId) "
            + "AS numFacturas FROM Cliente cl "
            + "WHERE cl.clienteId = :clienteId GROUP BY cl")
    ClienteDTO findClienteDTO(@Param("clienteId") String clienteId);
}
