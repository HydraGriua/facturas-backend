package com.zytrust.facturas.repositorios;

import com.zytrust.facturas.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto,String> {
}