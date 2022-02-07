package com.zytrust.facturas.repositorios;

import com.zytrust.facturas.modelos.CategoriaProducto;
import com.zytrust.facturas.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto,String> {
    List<Producto> findAllByCategoriaCategoriaId(String categoriaId);
}
