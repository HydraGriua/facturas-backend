package com.zytrust.facturas.servicios;

import com.zytrust.facturas.dtos.cliente.ClienteDto;
import com.zytrust.facturas.dtos.cliente.CreateClienteDto;
import com.zytrust.facturas.modelos.Cliente;

import java.util.List;

public interface ClienteServicio {
    List<ClienteDto> getAll();
    ClienteDto getCliente(String id) throws Exception;
    ClienteDto createCliente(CreateClienteDto cliente);
}
