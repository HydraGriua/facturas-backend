package com.zytrust.facturas.servicios.implementaciones;

import com.zytrust.facturas.dtos.CreateClienteDto;
import com.zytrust.facturas.dtos.CreateProductoDto;
import com.zytrust.facturas.modelos.CategoriaProducto;
import com.zytrust.facturas.modelos.Producto;
import com.zytrust.facturas.repositorios.CategoriaProductoRepositorio;
import com.zytrust.facturas.repositorios.ProductoRepositorio;
import com.zytrust.facturas.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;

    @Autowired
    CategoriaProductoRepositorio categoriaProductoRepositorio;

    @Override
    public List<Producto> getAll() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto getProducto(String id) throws Exception {
        return productoRepositorio.findById(id).orElseThrow(()-> new Exception("No se encontro Producto con id:" + id));
    }

    @Override
    public Producto createProducto(CreateProductoDto producto) throws Exception {
        CategoriaProducto categoria = categoriaProductoRepositorio.findById(producto.getCategoriaId()).orElseThrow(()-> new Exception("No se encontro Categoria de Producto con id:" + producto.getCategoriaId()));
        Producto productoEntidad = Producto.builder()
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precioUnitario(producto.getPrecioUnitario())
                .categoria(categoria)
                .build();
        return productoRepositorio.save(productoEntidad);
    }
}
