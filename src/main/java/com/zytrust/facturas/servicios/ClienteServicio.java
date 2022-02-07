package com.zytrust.facturas.servicios;

import com.zytrust.facturas.dtos.cliente.CreateClienteDto;
import com.zytrust.facturas.modelos.Cliente;

import java.util.List;

public interface ClienteServicio {
    List<Cliente> getAll();
    Cliente getCliente(String id) throws Exception;
    Cliente createCliente(CreateClienteDto cliente);
}
