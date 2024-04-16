package com.banco.api.service.impl;

import com.banco.api.dto.CuentaDto;
import com.banco.api.dto.MovimientoDto;
import com.banco.api.exception.SaldoNoDisponibleException;
import com.banco.api.mapper.MovimientoMapper;
import com.banco.api.repository.MovimientoRepository;
import com.banco.api.service.CuentaService;
import com.banco.api.service.MovimientoService;
import com.banco.api.util.Constantes;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final CuentaService cuentaService;
    private final MovimientoMapper mapper;
    @Override
    public MovimientoDto register(MovimientoDto movimiento) {

        CuentaDto cuenta = cuentaService.getById(movimiento.getCuenta().getId());

        if ( cuenta.getSaldo().compareTo(movimiento.getValor()) == Constantes.COMPARETO_MENOR &&
                movimiento.getTipoMovimiento().getId().equals(Constantes.TIPO_MOVIMIENTO_CREDITO) ) {
            throw new SaldoNoDisponibleException(Constantes.SALDO_NO_DISPONIBLE);
        }

        if ( movimiento.getTipoMovimiento().getId().equals(Constantes.TIPO_MOVIMIENTO_CREDITO) ) {
            cuenta.setSaldo( cuenta.getSaldo().subtract(movimiento.getValor()) );
        }

        if ( movimiento.getTipoMovimiento().getId().equals(Constantes.TIPO_MOVIMIENTO_DEBITO) ) {
            cuenta.setSaldo( cuenta.getSaldo().add(movimiento.getValor()) );
        }

        cuentaService.register(cuenta);

        return mapper.toDto( movimientoRepository.save( mapper.toEntity(movimiento)) );
    }

    @Override
    public List<MovimientoDto> findByCuentaAndFecha(Integer id, LocalDateTime fechaStart, LocalDateTime fechaEnd) {
        return mapper.toDtos(movimientoRepository.findByCuentaAndFecha(id, fechaStart, fechaEnd));
    }
}