package com.zytrust.facturas.controladores;

import com.zytrust.facturas.dtos.ApiResponse;
import com.zytrust.facturas.dtos.detalle.CreateDetalleFacturaDto;
import com.zytrust.facturas.dtos.detalle.DetalleFacturaDto;
import com.zytrust.facturas.modelos.DetalleFactura;
import com.zytrust.facturas.servicios.DetalleFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping()
public class DetalleFacturaControlador {

    @Autowired
    DetalleFacturaServicio detalleFacturaServicio;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detalles")
    public ApiResponse<List<DetalleFacturaDto>> getAllDetalleFactura(){
        return  new ApiResponse<>("Success", String.valueOf(HttpStatus.OK),"OK",
                detalleFacturaServicio.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/facturas/{facturaId}/detalles")
    public ApiResponse<List<DetalleFacturaDto>> getAllDetalleFacturaByFacturaId(@PathVariable String facturaId) throws Exception {
        return  new ApiResponse<>("Success", String.valueOf(HttpStatus.OK),"OK",
                detalleFacturaServicio.getAllByFacturaId(facturaId));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ApiResponse<DetalleFacturaDto> createDetalleFactura(@RequestBody @Valid CreateDetalleFacturaDto detalleFactura) throws Exception {
        return new ApiResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                detalleFacturaServicio.createDetalleFactura(detalleFactura));
    }
}
