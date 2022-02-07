/*
 * @(#)ProductoServicioImpl.java
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
import com.zytrust.facturas.dtos.producto.CreateProductoDto;
import com.zytrust.facturas.dtos.producto.ProductoDto;
import com.zytrust.facturas.modelos.CategoriaProducto;
import com.zytrust.facturas.modelos.Producto;
import com.zytrust.facturas.repositorios.CategoriaProductoRepositorio;
import com.zytrust.facturas.repositorios.ProductoRepositorio;
import com.zytrust.facturas.servicios.ProductoServicio;
import com.zytrust.facturas.utiles.ConvertidorDto;

/**
 * Esta clase representa a una implementacion de la interfaz
 * ProductoServicio y debe ser
 * usada para realizar
 * logica de negocio y realizar intercambio de Data con repositorios y
 * controladores
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Service
public class ProductoServicioImpl implements ProductoServicio {

    /** Repositorio de producto con inyeccion de dependencia */
    @Autowired
    ProductoRepositorio productoRepositorio;

    /** Repositorio de categoria de producto con inyeccion de dependencia */
    @Autowired
    CategoriaProductoRepositorio categoriaProductoRepositorio;

    /** convertidor de entidades a Dto con inyeccion de dependencia */
    @Autowired
    private ConvertidorDto converter;

    /**
     * Permite obtener todos los productos y mapearlos a una lista de Dto
     *
     * @return Retorna una lista dto de todos los productos
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductoDto> getAll() {
        return converter.productoToDto(productoRepositorio.findAll());
    }

    /**
     * Permite obtener todos los productos segun el identificador de categoria de
     * producto y mapearlos a una lista de Dto
     *
     * @param categoriaId Identificador de categoria de producto
     * @return Retorna una lista dto de todos los productos de una categoria
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductoDto> getAllByCategoria(String categoriaId) {
        return converter.productoToDto(productoRepositorio.findAllByCategoriaCategoriaId(categoriaId));
    }

    /**
     * Permite la obtencion de un producto segun el identificador de producto
     *
     * @param id Identificador de producto
     * @return Retorna un objeto de tipo ProductoDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion del producto
     */
    @Override
    @Transactional(readOnly = true)
    public ProductoDto getProducto(String id) throws Exception {
        return converter.productoToDto(productoRepositorio.findById(id)
                .orElseThrow(() -> new Exception("No se encontro Producto con id:" + id)));
    }

    /**
     * Permite crear un nuevo producto
     *
     * @param producto Dto de creacion para producto
     * @return Retorna un objeto de tipo ProductoDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion de la categoria de producto
     */
    @Override
    @Transactional
    public ProductoDto createProducto(CreateProductoDto producto) throws Exception {
        CategoriaProducto categoria = categoriaProductoRepositorio.findById(producto.getCategoriaId())
                .orElseThrow(() -> new Exception(
                        "No se encontro Categoria de Producto con id:" + producto.getCategoriaId()));

        Producto productoEntidad = Producto.builder()
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precioUnitario(producto.getPrecioUnitario())
                .categoria(categoria)
                .build();

        return converter.productoToDto(productoRepositorio.save(productoEntidad));
    }
}
