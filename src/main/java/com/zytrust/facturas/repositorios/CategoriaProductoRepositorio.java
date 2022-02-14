/*
 * @(#)CategoriaProductoRepositorio.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.zytrust.facturas.modelos.DTOS.CategoriaProductoDTO;
import com.zytrust.facturas.modelos.CategoriaProducto;

/**
 * Esta interfaz representa a un respositorio para categoria de producto y debe
 * ser usada para realizar
 * consultas a la base de datos e intercambiar datos con servicios.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Repository
public interface CategoriaProductoRepositorio extends JpaRepository<CategoriaProducto, String> {

    /**
     * Permite obtener todas las categorias de producto en formato DTO
     * @return Retorna una lista dto de categorias de producto
     */
    @Query(value = "SELECT cp.categoriaId AS codCategoria, cp.nombre AS nombre, "
            +"cp.descripcion AS descripcion,(SELECT COUNT(p) from Producto p "
            +"WHERE p.categoria.categoriaId = cp.categoriaId) AS numProductos "
            +"FROM CategoriaProducto cp GROUP BY cp")
    List<CategoriaProductoDTO> findAllCategoriaProductoDTO();

    /**
     * Permite categoria de producto segun identificador de categoria en formato dto
     * @param categoriaId Identificador de categoria
     * @return Retorna una lista dto de categorias de producto
     */
    @Query(value = "SELECT cp.categoriaId AS codCategoria, cp.nombre AS nombre, "
            +"cp.descripcion AS descripcion,(SELECT COUNT(p) from Producto p "
            +"WHERE p.categoria.categoriaId = cp.categoriaId) AS numProductos "
            +"FROM CategoriaProducto cp WHERE cp.categoriaId = :categoriaId GROUP BY cp")
    CategoriaProductoDTO findCategoriaProductoDTO(@Param("categoriaId") String categoriaId);
}
