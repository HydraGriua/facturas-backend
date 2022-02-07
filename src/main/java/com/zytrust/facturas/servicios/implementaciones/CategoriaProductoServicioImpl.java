/*
 * @(#)CategoriaProductoServicioImpl.java
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
import com.zytrust.facturas.dtos.categoria.CategoriaProductoDto;
import com.zytrust.facturas.dtos.categoria.CreateCategoriaProductoDto;
import com.zytrust.facturas.modelos.CategoriaProducto;
import com.zytrust.facturas.repositorios.CategoriaProductoRepositorio;
import com.zytrust.facturas.servicios.CategoriaProductoServicio;
import com.zytrust.facturas.utiles.ConvertidorDto;

/**
 * Esta clase representa a una implementacion de la interfaz
 * CategoriaProductoServicio y debe ser
 * usada para realizar
 * logica de negocio y realizar intercambio de Data con repositorios y
 * controladores
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Service
public class CategoriaProductoServicioImpl implements CategoriaProductoServicio {

    /** Repositorio de categoria de productos con inyeccion de dependencia */
    @Autowired
    CategoriaProductoRepositorio categoriaProductoRepositorio;

    /** convertidor de entidades a Dto con inyeccion de dependencia */
    @Autowired
    private ConvertidorDto converter;

    /**
     * Permite obtener todas las categorias de producto y mapearlas a una lista de
     * Dto
     *
     * @return Retorna una lista dto de todas las categorias de producto
     */
    @Override
    public List<CategoriaProductoDto> getAll() {
        return converter.categoriaProductoToDto(categoriaProductoRepositorio.findAll());
    }

    /**
     * Permite obtener una categoria de producto segun el identificador
     *
     * @param id Identificador de categoria de producto a buscar
     * @return Retorna un objeto de tipo CategoriaProductoDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion de la categoria
     */
    @Override
    public CategoriaProductoDto getCategoriaProducto(String id) throws Exception {
        return converter.categoriaProductoToDto(categoriaProductoRepositorio.findById(id)
                .orElseThrow(() -> new Exception("No se encontro Categoria de Producto con id:" + id)));
    }

    /**
     * Permite crear una nueva categoria de producto
     *
     * @param categoria Dto de creacion para categoria de producto
     * @return Retorna un Objeto de tipo CategoriaProductoDto
     */
    @Override
    public CategoriaProductoDto createCategoriaProducto(CreateCategoriaProductoDto categoria) {
        CategoriaProducto categoriaProducto = CategoriaProducto.builder()
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .build();
        return converter.categoriaProductoToDto(categoriaProductoRepositorio.save(categoriaProducto));
    }
}
