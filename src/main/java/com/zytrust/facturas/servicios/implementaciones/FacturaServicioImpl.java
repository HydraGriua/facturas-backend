package com.zytrust.facturas.servicios.implementaciones;

import com.zytrust.facturas.dtos.CreateFacturaDto;
import com.zytrust.facturas.dtos.FacturaDto;
import com.zytrust.facturas.modelos.Cliente;
import com.zytrust.facturas.modelos.Factura;
import com.zytrust.facturas.repositorios.ClienteRepositorio;
import com.zytrust.facturas.repositorios.FacturaRepositorio;
import com.zytrust.facturas.servicios.FacturaServicio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaServicioImpl implements FacturaServicio {

    @Autowired
    FacturaRepositorio facturaRepositorio;

    @Autowired
    ClienteRepositorio clienteRepositorio;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public List<FacturaDto> getAll() {
        return facturaRepositorio.findAll().stream()
                .map(this::facturaToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public FacturaDto getFactura(String id) throws Exception {
        return facturaToDto(facturaRepositorio.findById(id).orElseThrow(()-> new Exception("No se encontro Factura con id:" + id)));
    }

    @Override
    @Transactional
    public FacturaDto createFactura(CreateFacturaDto factura) throws Exception {
        Cliente cliente = clienteRepositorio.findById(factura.getClienteId()).orElseThrow(()-> new Exception("No se encontro Cliente con id:" + factura.getClienteId()));
        Factura facturaEntidad = Factura.builder()
                .cliente(cliente)
                .direccion(factura.getDireccion())
                .fechaEmision(factura.getFechaEmision())
                .fechaPago(factura.getFechaPago())
                .tipoPago(factura.getTipoPago())
                .estado('i')
                .subtotal(factura.getSubtotal())
                .impuesto(factura.getSubtotal().multiply(new BigDecimal(0.18)))
                .total(factura.getTotal())
                .build();
        return facturaToDto(facturaRepositorio.save(facturaEntidad));
    }

    public FacturaDto facturaToDto(Factura factura){
        return modelMapper.map(factura, FacturaDto.class);
    }
}
