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

import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase representa a un dto de categoria de producto y debe ser usada para almacenar
 * datos y mapearlos con una entidad categoria de producto.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Getter
@Setter
public class CategoriaProductoDto {

    private String categoriaId; /** Identificador de categoria de productos */
    private String nombre; /** Nombre de categoria de productos */
    private String descripcion; /** Descripcion de categoria de productos */
}
