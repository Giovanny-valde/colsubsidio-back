package com.banco.api.dto;

import com.banco.api.entity.Cliente;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CuentaDto {

    private Integer id;
    private Integer numero;
    private BigDecimal saldo;
    private Cliente cliente;
}
