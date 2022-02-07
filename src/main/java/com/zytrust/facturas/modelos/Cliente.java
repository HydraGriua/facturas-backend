package com.zytrust.facturas.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FAC_CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIE_ID", length = 20, nullable = false)
    private String clienteId;

    @Column(name = "CLIE_NUM_DOC", length = 20, nullable = false)
    private String numDocumento;

    @Column(name = "CLIE_TIPO_DOC", length = 20, nullable = false)
    private String tipoDocumento;

    @Column(name = "CLIE_PRIM_NOMBRE", length = 40, nullable = false)
    private String primerNombre;

    @Column(name = "CLIE_PRIM_APELLIDO", length = 40, nullable = false)
    private String primerApellido;

    @Column(name = "CLIE_FECHA_NACIMIENTO", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "CLIE_GENERO", nullable = false)
    private Character genero;

    @Column(name = "CLIE_EMAIL", length = 30, nullable = false)
    private String email;

    @Column(name = "CLIE_CELULAR", length = 20, nullable = false)
    private String celular;

    @Column(name = "CLIE_DIRECCION", length = 200, nullable = false)
    private String direccion;

    @Column(name = "CLIE_NOM_EMPRESA", length = 100, nullable = false)
    private String nombreEmpresa;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Factura> facturas;
}
