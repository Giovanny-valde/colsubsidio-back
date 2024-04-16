package com.banco.api.service.impl;

import com.banco.api.dto.CuentaDto;
import com.banco.api.exception.ModeloNotFoundException;
import com.banco.api.mapper.CuentaMapper;
import com.banco.api.repository.CuentaRepository;
import com.banco.api.service.CuentaService;
import com.banco.api.util.Constantes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository repository;
    private final CuentaMapper mapper;

    @Override
    public List<CuentaDto> getAll() {
        return mapper.toDtos( repository.findAll() );
    }

    @Override
    public CuentaDto getById(Integer id) {
        return mapper.toDto( repository.findById(id).orElseThrow(() -> new ModeloNotFoundException(Constantes.ID_NO_ENCONTRADO + id)) );
    }

    @Override
    public CuentaDto register(CuentaDto cuenta) {
        return mapper.toDto(repository.save( mapper.toEntity(cuenta)) );
    }

    @Override
    public CuentaDto update(CuentaDto cuenta) {
        this.getById(cuenta.getId());
        return mapper.toDto(repository.save( mapper.toEntity(cuenta)) );
    }

    @Override
    public void delete(Integer id) {
        this.getById(id);
        repository.deleteById(id);
    }
}
