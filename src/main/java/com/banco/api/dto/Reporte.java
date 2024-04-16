package com.banco.api.dto;

import com.banco.api.entity.Cliente;
import com.banco.api.entity.Cuenta;

import java.util.List;

public interface Reporte {

    Cuenta getCuenta();
    Integer getCredito();
    Integer getDebito();

}
