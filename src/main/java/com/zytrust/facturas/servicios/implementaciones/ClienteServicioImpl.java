package com.zytrust.facturas.servicios.implementaciones;

import com.zytrust.facturas.dtos.CreateClienteDto;
import com.zytrust.facturas.modelos.Cliente;
import com.zytrust.facturas.repositorios.ClienteRepositorio;
import com.zytrust.facturas.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> getAll() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente getCliente(String id) throws Exception {
        return clienteRepositorio.findById(id).orElseThrow(()-> new Exception("No se encontro Cliente con id:" + id));
    }

    @Override
    public Cliente createCliente(CreateClienteDto cliente) {
        Cliente clienteEntidad = Cliente.builder()
                .primerNombre(cliente.getPrimerNombre())
                .primerApellido(cliente.getPrimerApellido())
                .numDocumento(cliente.getNumDocumento())
                .tipoDocumento(cliente.getTipoDocumento())
                .fechaNacimiento(cliente.getFechaNacimiento())
                .genero(cliente.getGenero())
                .email(cliente.getEmail())
                .celular(cliente.getCelular())
                .direccion(cliente.getDireccion())
                .nombreEmpresa(cliente.getNombreEmpresa())
                .build();
        return clienteRepositorio.save(clienteEntidad);
    }
}
