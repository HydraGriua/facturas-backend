package com.zytrust.facturas.controladores;

import com.zytrust.facturas.dtos.ApiResponse;
import com.zytrust.facturas.dtos.CreateFacturaDto;
import com.zytrust.facturas.dtos.FacturaDto;
import com.zytrust.facturas.servicios.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaControlador {

    @Autowired
    FacturaServicio facturaServicio;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ApiResponse<List<FacturaDto>> getAllFacturas(){
        return  new ApiResponse<>("Success", String.valueOf(HttpStatus.OK),"OK",
                facturaServicio.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ApiResponse<FacturaDto> createFactura(@RequestBody @Valid CreateFacturaDto factura) throws Exception {
        return new ApiResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                facturaServicio.createFactura(factura));
    }
}
