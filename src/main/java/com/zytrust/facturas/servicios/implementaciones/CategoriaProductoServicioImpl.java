package com.zytrust.facturas.servicios.implementaciones;

import com.zytrust.facturas.dtos.categoria.CreateCategoriaProductoDto;
import com.zytrust.facturas.modelos.CategoriaProducto;
import com.zytrust.facturas.repositorios.CategoriaProductoRepositorio;
import com.zytrust.facturas.servicios.CategoriaProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProductoServicioImpl implements CategoriaProductoServicio {

    @Autowired
    CategoriaProductoRepositorio categoriaProductoRepositorio;

    @Override
    public List<CategoriaProducto> getAll() {
        return categoriaProductoRepositorio.findAll();
    }

    @Override
    public CategoriaProducto getCategoriaProducto(String id) throws Exception {
        return categoriaProductoRepositorio.findById(id).orElseThrow(()-> new Exception("No se encontro Categoria de Producto con id:" + id));
    }

    @Override
    public CategoriaProducto createCategoriaProducto(CreateCategoriaProductoDto categoria) {
        CategoriaProducto categoriaProducto = CategoriaProducto.builder()
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .build();
        return categoriaProductoRepositorio.save(categoriaProducto);
    }
}
