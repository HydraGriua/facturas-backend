/*
 * @(#)CategoriaProducto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.modelos.DTOS;

import java.time.LocalDate;

/**
 * Esta interfaz representa un dto de cliente y debe ser usada para obtener
 * datos a traves de los repositorios.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 11/02/2022
 */

public interface ClienteDTO {

    /** Identificador de cliente */
    String getCodCliente();

    /** Numero identificador de documento de cliente */
    String getNroDocumento();

    /** Tipo de documento de cliente */
    String getTipoDocumento();

    /** Primer nombre de cliente */
    String getNombre();

    /** Primer apellido de cliente */
    String getApellido();

    /** Fecha de nacimiento de cliente */
    LocalDate getFechaNacimiento();

    /** Genero de cliente */
    Character getGenero();

    /** Email de cliente */
    String getEmail();

    /** Celular de cliente */
    String getCelular();

    /** Direccion de cliente */
    String getDireccion();

    /** Nombre de empresa donde labora el cliente */
    String getNombreEmpresa();

    /** Cantidad de facturas pertenecientes al cliente */
    Integer getNumFacturas();
}
