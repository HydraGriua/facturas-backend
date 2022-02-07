/*
 * @(#)ProductoDto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.dtos.producto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase representa a un dto de producto y debe ser usada para almacenar
 * datos y mapearlos con una entidad producto.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Getter
@Setter
public class ProductoDto {

    private String productoId; /** Identificador de producto */
    private String nombre; /** Nombre de producto */
    private String descripcion; /** Descripcion de producto */
    private BigDecimal precioUnitario; /** Precio de venta unitario de producto */
    private String categoriaId; /** Categoria de producto */
}
