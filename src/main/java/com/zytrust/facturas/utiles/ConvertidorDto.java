package com.zytrust.facturas.utiles;

import com.zytrust.facturas.dtos.Factura.FacturaDto;
import com.zytrust.facturas.dtos.cliente.ClienteDto;
import com.zytrust.facturas.modelos.Cliente;
import com.zytrust.facturas.modelos.Factura;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ConvertidorDto {
    private final ModelMapper modelMapper = new ModelMapper();

    public FacturaDto facturaToDto(Factura factura){
        return modelMapper.map(factura, FacturaDto.class);
    }

    public ClienteDto clienteToDto(Cliente cliente){
        return  modelMapper.map(cliente, ClienteDto.class);
    }
}
