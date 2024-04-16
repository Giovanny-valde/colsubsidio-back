package com.banco.api.service.impl;

import com.banco.api.dto.ClienteDto;
import com.banco.api.dto.Reporte;
import com.banco.api.exception.ModeloNotFoundException;
import com.banco.api.mapper.ClienteMapper;
import com.banco.api.repository.ClienteRepository;
import com.banco.api.service.ClienteService;
import com.banco.api.util.Constantes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    @Override
    public List<ClienteDto> getAll() {
        return mapper.toDtos( repository.findAll() );
    }

    @Override
    public ClienteDto getById(Integer id) {
        return mapper.toDto( repository.findById(id).orElseThrow(() -> new ModeloNotFoundException(Constantes.ID_NO_ENCONTRADO + id)) );
    }

    @Override
    public ClienteDto register(ClienteDto cliente) {
        return mapper.toDto( repository.save( mapper.toEntity( cliente )) );
    }

    @Override
    public ClienteDto update(ClienteDto cliente) {
        this.getById(cliente.getId());
        return mapper.toDto( repository.save( mapper.toEntity( cliente )) );
    }

    @Override
    public void delete(Integer id) {
        this.getById(id);
        repository.deleteById(id);
    }

    @Override
    public List<Reporte> findByClienteAndFecha(Integer id, LocalDateTime fechaStart, LocalDateTime fechaEnd) {
        return repository.findByClienteAndFecha(id, fechaStart, fechaEnd);
    }
}
