package com.zytrust.facturas.servicios.implementaciones;

import com.zytrust.facturas.dtos.producto.CreateProductoDto;
import com.zytrust.facturas.dtos.producto.ProductoDto;
import com.zytrust.facturas.modelos.CategoriaProducto;
import com.zytrust.facturas.modelos.Producto;
import com.zytrust.facturas.repositorios.CategoriaProductoRepositorio;
import com.zytrust.facturas.repositorios.ProductoRepositorio;
import com.zytrust.facturas.servicios.ProductoServicio;
import com.zytrust.facturas.utiles.ConvertidorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;

    @Autowired
    CategoriaProductoRepositorio categoriaProductoRepositorio;

    @Autowired
    private ConvertidorDto converter;

    @Override
    public List<ProductoDto> getAll() {
        return converter.productoToDto(productoRepositorio.findAll());
    }

    @Override
    public List<ProductoDto> getAllByCategoria(String categoriaId) {
        return converter.productoToDto(productoRepositorio.findAllByCategoriaCategoriaId(categoriaId));
    }

    @Override
    public ProductoDto getProducto(String id) throws Exception {
        return converter.productoToDto(productoRepositorio.findById(id)
                .orElseThrow(()-> new Exception("No se encontro Producto con id:" + id)));
    }

    @Override
    public ProductoDto createProducto(CreateProductoDto producto) throws Exception {
        CategoriaProducto categoria = categoriaProductoRepositorio.findById(producto.getCategoriaId())
                .orElseThrow(()-> new Exception("No se encontro Categoria de Producto con id:" + producto.getCategoriaId()));

        Producto productoEntidad = Producto.builder()
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precioUnitario(producto.getPrecioUnitario())
                .categoria(categoria)
                .build();

        return converter.productoToDto(productoRepositorio.save(productoEntidad));
    }
}
