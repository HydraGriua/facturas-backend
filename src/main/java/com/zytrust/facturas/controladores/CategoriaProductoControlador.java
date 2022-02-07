/*
 * @(#)CategoriaProductoControlador.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.controladores;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.zytrust.facturas.dtos.ApiResponse;
import com.zytrust.facturas.dtos.categoria.CategoriaProductoDto;
import com.zytrust.facturas.dtos.categoria.CreateCategoriaProductoDto;
import com.zytrust.facturas.servicios.CategoriaProductoServicio;

/**
 * Esta clase representa a un controlador de categoria de productos y debe ser
 * usada para realizar
 * peticiones HTTP y proveer data del API.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@RestController
@RequestMapping("/categoria-productos")
public class CategoriaProductoControlador {

    /** Servicio de categoria de producto con inyeccion de dependencia */
    @Autowired
    CategoriaProductoServicio categoriaProductoServicio;

    /**
     * Permite obtener todas las categorias de productos
     *
     * @return Retorna un ApiResponse conteniendo la lista dto de todas las
     *         categorias de productos
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ApiResponse<List<CategoriaProductoDto>> getAllCategoriaProducto() {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                categoriaProductoServicio.getAll());
    }

    /**
     * Permite crear una categoria de producto
     *
     * @param categoriaProducto Dto de creacion para categoria de producto
     * @return Retorna un ApiResponse conteniendo un Objeto de tipo CategoriaProductoDto
     */
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ApiResponse<CategoriaProductoDto> createCategoriaProducto(
            @RequestBody @Valid CreateCategoriaProductoDto categoriaProducto) {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                categoriaProductoServicio.createCategoriaProducto(categoriaProducto));
    }
}
