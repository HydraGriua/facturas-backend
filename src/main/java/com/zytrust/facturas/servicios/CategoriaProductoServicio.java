/*
 * @(#)CategoriaProductoServicio.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.servicios;

import java.util.List;
import com.zytrust.facturas.dtos.categoria.CategoriaProductoDto;
import com.zytrust.facturas.dtos.categoria.CreateCategoriaProductoDto;
import com.zytrust.facturas.modelos.DTOS.CategoriaProductoDTO;

/**
 * Esta interfaz representa a un servicio para producto y debe ser usada para
 * ser
 * la interfaz de la clase servicio implementada.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

public interface CategoriaProductoServicio {

    /**
     * Permite obtener todas las categorias de producto y mapearlas a una lista de
     * Dto
     *
     * @return Retorna una lista dto de todas las categorias de producto
     */
    List<CategoriaProductoDto> getAll();

    /**
     * Permite obtener una categoria de producto segun el identificador
     *
     * @param id Identificador de categoria de producto a buscar
     * @return Retorna un objeto de tipo CategoriaProductoDto
     */
    CategoriaProductoDto getCategoriaProducto(String id);

    /**
     * Permite crear una nueva categoria de producto
     *
     * @param categoria Dto de creacion para categoria de producto
     * @return Retorna un Objeto de tipo CategoriaProductoDto
     */
    CategoriaProductoDto createCategoriaProducto(CreateCategoriaProductoDto categoria);

    List<CategoriaProductoDTO> findAllCategoriaProductoDTO();
}
