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

import com.zytrust.facturas.modelos.DTOS.ProductoDTO;
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
     * Permite obtener todos los productos en formato DTO
     * @return Retorna una lista dto de todos los productos
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/productos/DTO")
    public ApiResponse<List<ProductoDTO>> getAllProductoDTO() {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                productoServicio.findAllProductoDTO());
    }

    /**
     * Permite obtener todos los productos segun identificador de categoria en formato DTO
     * @param categoriaId Identificador de categoria
     * @return Retorna una lista dto de productos
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/categoria-productos/{categoriaId}/productos/DTO")
    public ApiResponse<List<ProductoDTO>> getAllProductoDTOByCategoriaId(@PathVariable String categoriaId) {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                productoServicio.findAllProductoDTOByCategoriaId(categoriaId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/productos/DTO/{productoId}")
    public ApiResponse<ProductoDTO> getProductoDTO(@PathVariable String productoId) {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                productoServicio.findProductoDTO(productoId));
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
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/productos")
    public ApiResponse<ProductoDto> createProducto(@RequestBody @Valid CreateProductoDto producto) throws Exception {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.CREATED), "CREATED",
                productoServicio.createProducto(producto));
    }
}
