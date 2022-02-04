package com.zytrust.facturas.modelos;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fac_clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cli_id",nullable = false)
    private String clienteId;

    @Column(name = "cli_num_doc",nullable = false)
    private String numDocumento;

    @Column(name = "cli_tipo_doc",nullable = false)
    private String tipoDocumento;

    @Column(name = "cli_prim_nombre",nullable = false)
    private String primerNombre;

    @Column(name = "cli_prim_apellido",nullable = false)
    private String primerApellido;

    @Column(name = "cli_fecha_nacimiento",nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "cli_genero",nullable = false)
    private Character genero;

    @Column(name = "cli_email",nullable = false)
    private String email;

    @Column(name = "cli_celular",nullable = false)
    private String celular;

    @Column(name = "cli_direccion",nullable = false)
    private String direccion;

    @Column(name = "cli_nom_empresa",nullable = false)
    private String nombreEmpresa;

    //TODO: ORM Factura

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Factura> facturas;
}
