package com.banco.api.service;

import com.banco.api.dto.MovimientoDto;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimientoService {

    MovimientoDto register(MovimientoDto movimiento);

    List<MovimientoDto> findByCuentaAndFecha(Integer id, LocalDateTime fechaStart, LocalDateTime fechaEnd);
}
