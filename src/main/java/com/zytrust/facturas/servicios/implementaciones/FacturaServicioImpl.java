package com.zytrust.facturas.servicios.implementaciones;

import com.zytrust.facturas.dtos.Factura.CreateFacturaDto;
import com.zytrust.facturas.dtos.Factura.FacturaDto;
import com.zytrust.facturas.modelos.Cliente;
import com.zytrust.facturas.modelos.Factura;
import com.zytrust.facturas.repositorios.ClienteRepositorio;
import com.zytrust.facturas.repositorios.FacturaRepositorio;
import com.zytrust.facturas.servicios.FacturaServicio;
import com.zytrust.facturas.utiles.ConvertidorDto;
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

    @Autowired
    private ConvertidorDto converter;

    @Override
    @Transactional(readOnly = true)
    public List<FacturaDto> getAll() {
        return converter.facturaToDto(facturaRepositorio.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public FacturaDto getFactura(String id) throws Exception {
        return converter.facturaToDto(facturaRepositorio.findById(id)
                .orElseThrow(()-> new Exception("No se encontro Factura con id:" + id)));
    }

    @Override
    @Transactional
    public FacturaDto createFactura(CreateFacturaDto factura) throws Exception {

        Cliente cliente = clienteRepositorio.findById(factura.getClienteId())
                .orElseThrow(()-> new Exception("No se encontro Cliente con id:" + factura.getClienteId()));

        BigDecimal subtotal = factura.getSubtotal();
        BigDecimal impuesto = factura.getSubtotal().multiply(new BigDecimal("0.18"));
        BigDecimal total = subtotal.add(impuesto);

        Factura facturaEntidad = Factura.builder()
                .cliente(cliente)
                .direccion(factura.getDireccion())
                .fechaHoraEmision(factura.getFechaEmision())
                .fechaHoraPago(factura.getFechaPago())
                .tipoPago(factura.getTipoPago())
                .estado('i')
                .subtotal(subtotal)
                .impuesto(impuesto)
                .total(total)
                .build();

        return converter.facturaToDto(facturaRepositorio.save(facturaEntidad));
    }

}
