package com.zytrust.facturas.servicios;

import com.zytrust.facturas.dtos.CreateCategoriaProductoDto;
import com.zytrust.facturas.modelos.CategoriaProducto;

import java.util.List;

public interface CategoriaProductoServicio {
    List<CategoriaProducto> getAll();
    CategoriaProducto getCategoriaProducto(String id) throws Exception;
    CategoriaProducto createCategoriaProducto(CreateCategoriaProductoDto categoria);
}
