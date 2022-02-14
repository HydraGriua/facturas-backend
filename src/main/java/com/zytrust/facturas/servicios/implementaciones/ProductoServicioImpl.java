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
import java.util.Optional;

import com.zytrust.facturas.modelos.DTOS.ProductoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zytrust.facturas.dtos.producto.CreateProductoDto;
import com.zytrust.facturas.dtos.producto.ProductoDto;
import com.zytrust.facturas.excepciones.FacturasException;
import com.zytrust.facturas.modelos.CategoriaProducto;
import com.zytrust.facturas.modelos.Producto;
import com.zytrust.facturas.repositorios.CategoriaProductoRepositorio;
import com.zytrust.facturas.repositorios.ProductoRepositorio;
import com.zytrust.facturas.servicios.ProductoServicio;
import com.zytrust.facturas.utiles.CodigoError;
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

    /** Repositorio de categoria de productos con inyeccion de dependencia */
    @Autowired
    CategoriaProductoRepositorio categoriaProductoRepositorio;

    /** convertidor de entidades a Dto con inyeccion de dependencia */
    @Autowired
    private ConvertidorDto converter;

    /** Logger de servicio */
    private static final Logger logger = LoggerFactory.getLogger(ProductoServicioImpl.class);

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
        return converter.productoToDto(productoRepositorio
                .findAllByCategoriaCategoriaId(categoriaId));
    }

    /**
     * Permite la obtencion de un producto segun el identificador de producto
     *
     * @param id Identificador de producto
     * @return Retorna un objeto de tipo ProductoDto
     */
    @Override
    @Transactional(readOnly = true)
    public ProductoDto getProducto(String id) {

        Optional<Producto> opt = productoRepositorio.findById(id);

        if (opt.isEmpty()) {
            logger.info("No se encontro el producto con el id {}", id);
            throw new FacturasException(CodigoError.PRODUCTO_NO_EXISTE);
        }

        return converter.productoToDto(opt.get());
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
    public ProductoDto createProducto(CreateProductoDto producto) {

        Optional<CategoriaProducto> categoria = categoriaProductoRepositorio
        .findById(producto.getCategoriaId());

        if (categoria.isEmpty()) {
            logger.info("No se encontro la categoria con el id {}", producto.getCategoriaId());
            throw new FacturasException(CodigoError.CATEGORIA_PRODUCTO_NO_EXISTE);
        }

        Producto productoEntidad = Producto.builder()
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precioUnitario(producto.getPrecioUnitario())
                .categoria(categoria.get())
                .build();

        productoEntidad = productoRepositorio.save(productoEntidad);
        logger.debug("Se creo el producto {}", productoEntidad.toString());

        return converter.productoToDto(productoEntidad);
    }

    /**
     * Permite obtener todos los productos en formato DTO
     *
     * @return Retorna una lista dto de todos los productos
     */
    @Override
    public List<ProductoDTO> findAllProductoDTO() {
        return productoRepositorio.findAllProductoDTO();
    }

    /**
     * Permite obtener todos los productos segun identificador de categoria en formato DTO
     *
     * @param categoriaId Identificador de categoria
     * @return Retorna una lista dto de productos
     */
    @Override
    public List<ProductoDTO> findAllProductoDTOByCategoriaId(String categoriaId) {
        return productoRepositorio.findAllProductoDTOByCategoriaId(categoriaId);
    }

    /**
     * Permite obtener todos los productos segun identificador de producto en formato DTO
     *
     * @param productoId Identificador de producto
     * @return Retorna dto de producto
     */
    @Override
    public ProductoDTO findProductoDTO(String productoId) {
        return productoRepositorio.findProductoDTO(productoId);
    }
}
