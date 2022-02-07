package com.zytrust.facturas.controladores;

import com.zytrust.facturas.dtos.ApiResponse;
import com.zytrust.facturas.dtos.cliente.CreateClienteDto;
import com.zytrust.facturas.modelos.Cliente;
import com.zytrust.facturas.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {
    @Autowired
    ClienteServicio clienteServicio;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ApiResponse<List<Cliente>> getAllClientes(){
        return  new ApiResponse<>("Success", String.valueOf(HttpStatus.OK),"OK",
                clienteServicio.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ApiResponse<Cliente> createCliente(@RequestBody @Valid CreateClienteDto cliente) throws Exception {
        return new ApiResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                clienteServicio.createCliente(cliente));
    }
}
