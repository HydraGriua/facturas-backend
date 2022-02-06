package com.zytrust.facturas.controladores;

import com.zytrust.facturas.dtos.ApiResponse;
import com.zytrust.facturas.dtos.CreateCategoriaProductoDto;
import com.zytrust.facturas.modelos.CategoriaProducto;
import com.zytrust.facturas.servicios.CategoriaProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categoria-productos")
public class CategoriaProductoControlador {
    @Autowired
    CategoriaProductoServicio categoriaProductoServicio;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ApiResponse<List<CategoriaProducto>> getAllCategoriaProducto(){
        return  new ApiResponse<>("Success", String.valueOf(HttpStatus.OK),"OK",
                categoriaProductoServicio.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ApiResponse<CategoriaProducto> createCategoriaProducto(@RequestBody @Valid CreateCategoriaProductoDto categoriaProducto) throws Exception {
        return new ApiResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                categoriaProductoServicio.createCategoriaProducto(categoriaProducto));
    }
}
