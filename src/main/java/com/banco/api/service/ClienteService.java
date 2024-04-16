package com.banco.api.service;

import com.banco.api.dto.ClienteDto;
import com.banco.api.dto.Reporte;

import java.time.LocalDateTime;
import java.util.List;

public interface ClienteService {

    List<ClienteDto> getAll();
    ClienteDto getById(Integer id);
    ClienteDto register(ClienteDto cliente);
    ClienteDto update(ClienteDto cliente);
    void delete(Integer id);

    List<Reporte> findByClienteAndFecha(Integer id, LocalDateTime fechaStart, LocalDateTime fechaEnd);



}
