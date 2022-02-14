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
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zytrust.facturas.dtos.categoria.CategoriaProductoDto;
import com.zytrust.facturas.modelos.DTOS.CategoriaProductoDTO;
import com.zytrust.facturas.dtos.categoria.CreateCategoriaProductoDto;
import com.zytrust.facturas.excepciones.FacturasException;
import com.zytrust.facturas.modelos.CategoriaProducto;
import com.zytrust.facturas.repositorios.CategoriaProductoRepositorio;
import com.zytrust.facturas.servicios.CategoriaProductoServicio;
import com.zytrust.facturas.utiles.CodigoError;
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

    /** Logger de servicio */
    private static final Logger logger = LoggerFactory.getLogger(CategoriaProductoServicioImpl.class);

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
     */
    @Override
    public CategoriaProductoDto getCategoriaProducto(String id) {
        Optional<CategoriaProducto> opt = categoriaProductoRepositorio.findById(id);
        if (opt.isEmpty()) {
            logger.info("No se encontro la categoria de producto con el id {}", id);
            throw new FacturasException(CodigoError.CATEGORIA_PRODUCTO_NO_EXISTE);
        }
        return converter.categoriaProductoToDto(opt.get());
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

        categoriaProducto = categoriaProductoRepositorio.save(categoriaProducto);
        logger.debug("Se creo la categoria {}", categoriaProducto.toString());

        return converter.categoriaProductoToDto(categoriaProducto);
    }

    /**
     * Permite obtener todas las categorias de producto en formato DTO
     * @return Retorna una lista dto de categorias de producto
     */
    @Override
    public List<CategoriaProductoDTO> findAllCategoriaProductoDTO() {
        return categoriaProductoRepositorio.findAllCategoriaProductoDTO();
    }
}
