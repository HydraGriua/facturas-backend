package com.zytrust.facturas.servicios;

import com.zytrust.facturas.dtos.categoria.CategoriaProductoDto;
import com.zytrust.facturas.dtos.categoria.CreateCategoriaProductoDto;
import com.zytrust.facturas.modelos.CategoriaProducto;

import java.util.List;

public interface CategoriaProductoServicio {
    List<CategoriaProductoDto> getAll();
    CategoriaProductoDto getCategoriaProducto(String id) throws Exception;
    CategoriaProductoDto createCategoriaProducto(CreateCategoriaProductoDto categoria);
}
