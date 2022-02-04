package com.zytrust.facturas.repositorios;

import com.zytrust.facturas.modelos.CategoriaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaProductoRepositorio extends JpaRepository<CategoriaProducto,String> {
}
