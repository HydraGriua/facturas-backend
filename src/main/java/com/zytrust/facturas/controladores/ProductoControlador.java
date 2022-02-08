/*
 * @(#)ProductoControlador.java
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
import com.zytrust.facturas.dtos.producto.CreateProductoDto;
import com.zytrust.facturas.dtos.producto.ProductoDto;
import com.zytrust.facturas.servicios.ProductoServicio;

/**
 * Esta clase representa a un controlador de producto y debe ser
 * usada para realizar
 * peticiones HTTP y proveer data del API.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@RestController
public class ProductoControlador {

    /** Servicio de producto con inyeccion de dependencia */
    @Autowired
    ProductoServicio productoServicio;

    /**
     * Permite obtener todos los productos
     *
     * @return Retorna un ApiResponse conteniendo la lista dto de todos los
     *         productos
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/productos")
    public ApiResponse<List<ProductoDto>> getAllProductos() {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                productoServicio.getAll());
    }

    /**
     * Permite obtener todos los productos segun el identificador de categoria de productos
     *
     * @return Retorna un ApiResponse conteniendo la lista dto de todos los
     *         productos de una categoria
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/categoria-productos/{categoriaId}/productos")
    public ApiResponse<List<ProductoDto>> getAllProductos(@PathVariable String categoriaId) {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                productoServicio.getAllByCategoria(categoriaId));
    }

    /**
     * Permite obtener todos los productos segun el identificador de categoria de productos
     *
     * @return Retorna un ApiResponse conteniendo la lista dto de todos los
     *         productos de una categoria
     * @throws Exception
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/productos/{productoId}")
    public ApiResponse<ProductoDto> getProducto(@PathVariable String productoId) throws Exception {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                productoServicio.getProducto(productoId));
    }

    /**
     * Permite crear un producto
     *
     * @param producto Dto de creacion para producto
     * @return Retorna un ApiResponse conteniendo un objeto de tipo ProductoDto
     * @throws Exception Emite una excepcion basica para informar de error en la
     *                   obtencion de la categoria de producto
     */
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/productos")
    public ApiResponse<ProductoDto> createProducto(@RequestBody @Valid CreateProductoDto producto) throws Exception {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                productoServicio.createProducto(producto));
    }
}
