package com.banco.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    private Integer numero;

    private BigDecimal saldo;

    @ManyToOne
    @JoinColumn(name = "id_cliente_fk", referencedColumnName = "id")
    private Cliente cliente;

}