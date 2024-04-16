package com.banco.api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MovimientoDto {

    private Integer id;
    private LocalDateTime fecha;
    private BigDecimal valor;
    private TipoMovimientoDto tipoMovimiento;
    private CuentaDto cuenta;
}
