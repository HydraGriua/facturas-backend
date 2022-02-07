package com.zytrust.facturas.servicios;

import com.zytrust.facturas.dtos.producto.CreateProductoDto;
import com.zytrust.facturas.modelos.Producto;

import java.util.List;

public interface ProductoServicio {
    List<Producto> getAll();
    Producto getProducto(String id) throws Exception;
    Producto createProducto(CreateProductoDto producto) throws Exception;
}
