package com.banco.api.service.impl;

import com.banco.api.dto.TipoMovimientoDto;
import com.banco.api.mapper.TipoMovimientoMapper;
import com.banco.api.repository.TipoMovimientoRepository;
import com.banco.api.service.TipoMovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoMovimientoServiceImpl implements TipoMovimientoService {

    private final TipoMovimientoRepository repository;
    private final TipoMovimientoMapper mapper;

    @Override
    public List<TipoMovimientoDto> getAll() {
        return mapper.toDtos( repository.findAll() );
    }
}
