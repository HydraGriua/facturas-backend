package com.zytrust.facturas.servicios;

import com.zytrust.facturas.dtos.producto.CreateProductoDto;
import com.zytrust.facturas.dtos.producto.ProductoDto;
import com.zytrust.facturas.modelos.Producto;

import java.util.List;

public interface ProductoServicio {
    List<ProductoDto> getAll();
    List<ProductoDto> getAllByCategoria(String categoriaId);
    ProductoDto getProducto(String id) throws Exception;
    ProductoDto createProducto(CreateProductoDto producto) throws Exception;
}
