/*
 * @(#)ProductoRepositorio.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.repositorios;

import java.util.List;
import com.zytrust.facturas.modelos.DTOS.ProductoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.zytrust.facturas.modelos.Producto;

/**
 * Esta interfaz representa a un respositorio para producto y debe ser usada
 * para realizar consultas a la base de datos e intercambiar datos
 * con servicios.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, String> {
    List<Producto> findAllByCategoriaCategoriaId(String categoriaId);

    /**
     * Permite obtener todos los productos en formato DTO
     * @return Retorna una lista dto de todos los productos
     */
    @Query(value = "SELECT p.productoId AS codProducto, p.nombre AS nombre, "
            +"p.descripcion AS descripcion, p.precioUnitario AS precioVenta, "
            +"p.categoria.categoriaId AS codCategoria "
            +"FROM Producto p GROUP BY p")
    List<ProductoDTO> findAllProductoDTO();

    /**
     * Permite obtener todos los productos segun identificador de categoria en formato DTO
     * @param categoriaId Identificador de categoria
     * @return Retorna una lista dto de productos
     */
    @Query(value = "SELECT p.productoId AS codProducto, p.nombre AS nombre, "
            +"p.descripcion AS descripcion, p.precioUnitario AS precioVenta, "
            +"p.categoria.categoriaId AS codCategoria "
            +"FROM Producto p WHERE p.categoria.categoriaId = :categoriaId GROUP BY p")
    List<ProductoDTO> findAllProductoDTOByCategoriaId(@Param("categoriaId") String categoriaId);

    /**
     * Permite obtener todos los productos segun identificador de producto en formato DTO
     * @param productoId Identificador de producto
     * @return Retorna dto de producto
     */
    @Query(value = "SELECT p.productoId AS codProducto, p.nombre AS nombre, "
            +"p.descripcion AS descripcion, p.precioUnitario AS precioVenta, "
            +"p.categoria.categoriaId AS codCategoria "
            +"FROM Producto p WHERE p.productoId = :productoId GROUP BY p")
    ProductoDTO findProductoDTO(@Param("productoId") String productoId);
}
