package com.banco.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    private LocalDateTime fecha;

    @Positive(message = "el valor debe ser positivo")
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_tipo_movimiento_fk", referencedColumnName = "id")
    private TipoMovimiento tipoMovimiento;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_fk", referencedColumnName = "id")
    private Cuenta cuenta;

}