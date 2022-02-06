package com.zytrust.facturas.controladores;

import com.zytrust.facturas.dtos.ApiResponse;
import com.zytrust.facturas.dtos.CreateProductoDto;
import com.zytrust.facturas.modelos.Producto;
import com.zytrust.facturas.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {
    @Autowired
    ProductoServicio productoServicio;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ApiResponse<List<Producto>> getAllProductos(){
        return  new ApiResponse<>("Success", String.valueOf(HttpStatus.OK),"OK",
                productoServicio.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ApiResponse<Producto> createProducto(@RequestBody @Valid CreateProductoDto producto) throws Exception {
        return new ApiResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                productoServicio.createProducto(producto));
    }
}
