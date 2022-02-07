package com.zytrust.facturas.utiles;

import com.zytrust.facturas.dtos.Factura.FacturaDto;
import com.zytrust.facturas.dtos.categoria.CategoriaProductoDto;
import com.zytrust.facturas.dtos.cliente.ClienteDto;
import com.zytrust.facturas.dtos.detalle.DetalleFacturaDto;
import com.zytrust.facturas.dtos.producto.ProductoDto;
import com.zytrust.facturas.modelos.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConvertidorDto {

    private final ModelMapper modelMapper = new ModelMapper();

    public FacturaDto facturaToDto(Factura factura) {
        return modelMapper.map(factura, FacturaDto.class);
    }

    public List<FacturaDto> facturaToDto(List<Factura> facturas) {
        return facturas.stream()
                .map(this::facturaToDto)
                .collect(Collectors.toList());
    }

    public ClienteDto clienteToDto(Cliente cliente) {
        return modelMapper.map(cliente, ClienteDto.class);
    }

    public List<ClienteDto> clienteToDto(List<Cliente> clientes) {
        return clientes.stream()
                .map(this::clienteToDto)
                .collect(Collectors.toList());
    }

    public ProductoDto productoToDto(Producto producto) {
        return modelMapper.map(producto, ProductoDto.class);
    }

    public List<ProductoDto> productoToDto(List<Producto> productos) {
        return productos.stream()
                .map(this::productoToDto)
                .collect(Collectors.toList());
    }

    public CategoriaProductoDto categoriaProductoToDto(CategoriaProducto categoriaProducto) {
        return modelMapper.map(categoriaProducto, CategoriaProductoDto.class);
    }

    public List<CategoriaProductoDto> categoriaProductoToDto(List<CategoriaProducto> categoriaProductos) {
        return categoriaProductos.stream()
                .map(this::categoriaProductoToDto)
                .collect(Collectors.toList());
    }

    public DetalleFacturaDto detalleFacturaToDto(DetalleFactura detalleFactura) {
        TypeMap<DetalleFactura, DetalleFacturaDto> propertyMapper = modelMapper.createTypeMap(DetalleFactura.class, DetalleFacturaDto.class);
        propertyMapper
                .addMappings(mapper -> mapper.map(src -> src.getFactura().getFacturaId(), DetalleFacturaDto::setFacturaId))
                .addMappings(mapper -> mapper.map(src -> src.getProducto().getProductoId(), DetalleFacturaDto::setProductoId));
        return modelMapper.map(detalleFactura, DetalleFacturaDto.class);
    }

    public List<DetalleFacturaDto> detalleFacturaToDto(List<DetalleFactura> detalleFacturas) {
        return detalleFacturas.stream()
                .map(this::detalleFacturaToDto)
                .collect(Collectors.toList());
    }
}
