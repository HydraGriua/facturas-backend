package com.zytrust.facturas.modelos;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FAC_CATEGORIA_PRODUCTOS")
public class CategoriaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATPROD_ID",nullable = false)
    private String categoriaId;

    @Column(name = "CATPROD_NOM",nullable = false)
    private String nombre;

    @Column(name = "CATPROD_DESCRIPCION",nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Producto> productos;
}
