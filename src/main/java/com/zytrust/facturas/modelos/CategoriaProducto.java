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
@Table(name = "fac_categoria_productos")
public class CategoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "catprod_id",nullable = false)
    private String categoriaId;

    @Column(name = "catprod_nom",nullable = false)
    private String nombre;

    @Column(name = "catprod_descripcion",nullable = false)
    private String descripcion;

    //TODO: ORM producto
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Producto> productos;
}
