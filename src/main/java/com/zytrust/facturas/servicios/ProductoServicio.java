/*
 * @(#)ProductoServicio.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.servicios;

import java.util.List;
import com.zytrust.facturas.dtos.producto.CreateProductoDto;
import com.zytrust.facturas.dtos.producto.ProductoDto;

/**
 * Esta interfaz representa a un servicio para producto y debe ser usada para
 * ser
 * la interfaz de la clase servicio implementada.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

public interface ProductoServicio {

    /**
     * Permite obtener todos los productos y mapearlos a una lista de Dto
     *
     * @return Retorna una lista dto de todos los productos
     */
    List<ProductoDto> getAll();

    /**
     * Permite obtener todos los productos segun el identificador de categoria de
     * producto y mapearlos a una lista de Dto
     *
     * @param categoriaId Identificador de categoria de producto
     * @return Retorna una lista dto de todos los productos de una categoria
     */
    List<ProductoDto> getAllByCategoria(String categoriaId);

    /**
     * Permite la obtencion de un producto segun el identificador de producto
     *
     * @param id Identificador de producto
     * @return Retorna un objeto de tipo ProductoDto
     */
    ProductoDto getProducto(String id);

    /**
     * Permite crear un nuevo producto
     *
     * @param producto Dto de creacion para producto
     * @return Retorna un objeto de tipo ProductoDto
     */
    ProductoDto createProducto(CreateProductoDto producto);
}
