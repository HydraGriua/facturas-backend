/*
 * @(#)ClienteServicioImpl.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.servicios.implementaciones;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zytrust.facturas.dtos.cliente.ClienteDto;
import com.zytrust.facturas.dtos.cliente.CreateClienteDto;
import com.zytrust.facturas.modelos.Cliente;
import com.zytrust.facturas.repositorios.ClienteRepositorio;
import com.zytrust.facturas.servicios.ClienteServicio;
import com.zytrust.facturas.utiles.ConvertidorDto;

/**
 * Esta clase representa a una implementacion de la interfaz
 * ClienteServicio y debe ser
 * usada para realizar
 * logica de negocio y realizar intercambio de Data con repositorios y
 * controladores
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Service
public class ClienteServicioImpl implements ClienteServicio {

    /** Repositorio de cliente con inyeccion de dependencia */
    @Autowired
    ClienteRepositorio clienteRepositorio;

    /** convertidor de entidades a Dto con inyeccion de dependencia */
    @Autowired
    private ConvertidorDto converter;

    /**
     * Permite obtener todos los clientes y mapearlos a una lista de Dto
     *
     * @return Retorna una lista dto de todos los clientes
     */
    @Override
    @Transactional(readOnly = true)
    public List<ClienteDto> getAll() {
        return converter.clienteToDto(clienteRepositorio.findAll());
    }

    /**
     * Permite la obtencion de un cliente segun el identificador de cliente
     *
     * @param id Identificador de cliente
     * @return Retorna un objeto de tipo ClienteDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion del cliente
     */
    @Override
    @Transactional(readOnly = true)
    public ClienteDto getCliente(String id) throws Exception {
        return converter.clienteToDto(clienteRepositorio.findById(id)
                .orElseThrow(() -> new Exception("No se encontro Cliente con id:" + id)));
    }

    /**
     * Permite crear un nuevo cliente
     *
     * @param cliente Dto de creacion para cliente
     * @return Retorna un objeto de tipo ClienteDto
     */
    @Override
    @Transactional
    public ClienteDto createCliente(CreateClienteDto cliente) {
        Cliente clienteEntidad = Cliente.builder()
                .primerNombre(cliente.getPrimerNombre())
                .primerApellido(cliente.getPrimerApellido())
                .numDocumento(cliente.getNumDocumento())
                .tipoDocumento(cliente.getTipoDocumento())
                .fechaNacimiento(cliente.getFechaNacimiento())
                .genero(cliente.getGenero())
                .email(cliente.getEmail())
                .celular(cliente.getCelular())
                .direccion(cliente.getDireccion())
                .nombreEmpresa(cliente.getNombreEmpresa())
                .build();

        return converter.clienteToDto(clienteRepositorio.save(clienteEntidad));
    }
}
