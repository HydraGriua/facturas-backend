package com.zytrust.facturas.servicios.implementaciones;

import com.zytrust.facturas.dtos.categoria.CategoriaProductoDto;
import com.zytrust.facturas.dtos.categoria.CreateCategoriaProductoDto;
import com.zytrust.facturas.modelos.CategoriaProducto;
import com.zytrust.facturas.repositorios.CategoriaProductoRepositorio;
import com.zytrust.facturas.servicios.CategoriaProductoServicio;
import com.zytrust.facturas.utiles.ConvertidorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProductoServicioImpl implements CategoriaProductoServicio {

    @Autowired
    CategoriaProductoRepositorio categoriaProductoRepositorio;

    @Autowired
    private ConvertidorDto converter;

    @Override
    public List<CategoriaProductoDto> getAll() {
        return converter.categoriaProductoToDto(categoriaProductoRepositorio.findAll());
    }

    @Override
    public CategoriaProductoDto getCategoriaProducto(String id) throws Exception {
        return converter.categoriaProductoToDto(categoriaProductoRepositorio.findById(id)
                .orElseThrow(()-> new Exception("No se encontro Categoria de Producto con id:" + id)));
    }

    @Override
    public CategoriaProductoDto createCategoriaProducto(CreateCategoriaProductoDto categoria) {
        CategoriaProducto categoriaProducto = CategoriaProducto.builder()
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .build();
        return converter.categoriaProductoToDto(categoriaProductoRepositorio.save(categoriaProducto));
    }
}
