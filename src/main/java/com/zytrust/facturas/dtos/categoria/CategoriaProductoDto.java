/*
 * @(#)CategoriaProductoDto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.dtos.categoria;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Esta clase representa a un dto de categoria de producto y debe ser usada para almacenar
 * datos y mapearlos con una entidad categoria de producto.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoriaProductoDto implements Serializable{

    /** Id de serializacion */
    private static final long serialVersionUID = 1L;

    /** Identificador de categoria de productos */
    private String categoriaId;

    /** Nombre de categoria de productos */
    private String nombre;

    /** Descripcion de categoria de productos */
    private String descripcion;
}
