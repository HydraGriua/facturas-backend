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
    String getCodCliente();
    String getNroDocumento();
    String getTipoDocumento();
    String getNombre();
    String getApellido();
    LocalDate getFechaNacimiento();
    Character getGenero();
    String getEmail();
    String getCelular();
    String getDireccion();
    String getNombreEmpresa();
    Integer getNumFacturas();
}
