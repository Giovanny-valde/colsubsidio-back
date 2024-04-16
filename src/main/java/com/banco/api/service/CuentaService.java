package com.banco.api.service;

import com.banco.api.dto.CuentaDto;

import java.util.List;

public interface CuentaService {

    List<CuentaDto> getAll();
    CuentaDto getById(Integer id);
    CuentaDto register(CuentaDto cuenta);
    CuentaDto update(CuentaDto cuenta);
    void delete(Integer id);
}
