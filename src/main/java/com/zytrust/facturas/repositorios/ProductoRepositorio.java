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
import org.springframework.data.jpa.repository.JpaRepository;
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
}
