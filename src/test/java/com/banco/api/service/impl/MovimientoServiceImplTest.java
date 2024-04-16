package com.banco.api.service.impl;

import com.banco.api.dto.CuentaDto;
import com.banco.api.dto.MovimientoDto;
import com.banco.api.dto.TipoMovimientoDto;
import com.banco.api.entity.Movimiento;
import com.banco.api.exception.SaldoNoDisponibleException;
import com.banco.api.mapper.MovimientoMapper;
import com.banco.api.repository.MovimientoRepository;
import com.banco.api.service.CuentaService;
import com.banco.api.util.Constantes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class MovimientoServiceImplTest {

    @Mock
    private MovimientoRepository movimientoRepository;

    @Mock
    private CuentaService cuentaService;

    @Mock
    private MovimientoMapper movimientoMapper;

    @InjectMocks
    private MovimientoServiceImpl movimientoService;

    @Captor
    private ArgumentCaptor<Movimiento> movimientoCaptor;

    @Captor
    private ArgumentCaptor<CuentaDto> cuentaCaptor;

    MovimientoDto movimiento = new MovimientoDto();
    TipoMovimientoDto tipoMovimiento = new TipoMovimientoDto();
    CuentaDto cuenta = new CuentaDto();


    @BeforeEach
    public void inicializar() {

        cuenta.setId(1);
        cuenta.setSaldo(BigDecimal.valueOf(100.0));

        tipoMovimiento.setId(Constantes.TIPO_MOVIMIENTO_DEBITO);

        movimiento.setValor(BigDecimal.valueOf(100.0));
        movimiento.setTipoMovimiento(tipoMovimiento);
        movimiento.setCuenta(cuenta);
    }

    @Test
    void guardar_exitoso_cuenta_debito() {
        BigDecimal valorCuentaEsperado = BigDecimal.valueOf(2000,1);
        BigDecimal valorMovimientoEsperado = BigDecimal.valueOf(1000,1);

        tipoMovimiento.setId(Constantes.TIPO_MOVIMIENTO_DEBITO);
        movimiento.setTipoMovimiento(tipoMovimiento);

        when(movimientoRepository.save(movimientoCaptor.capture())).thenReturn(new Movimiento());
        when(movimientoMapper.toDto(any())).thenReturn(movimiento);

        when(cuentaService.getById(any())).thenReturn(cuenta);
        when(cuentaService.register(cuentaCaptor.capture())).thenReturn(cuenta);

        MovimientoDto resultMovimiento = movimientoService.register(movimiento);
        CuentaDto resultCuenta = cuentaService.register(cuenta);


        assertEquals(cuentaCaptor.getValue().getSaldo(), valorCuentaEsperado);
    }

    @Test
    void guardar_exitoso_cuenta_credito() {
        BigDecimal valorCuentaEsperado = BigDecimal.valueOf(00,1);
        BigDecimal valorMovimientoEsperado = BigDecimal.valueOf(1000,1);

        tipoMovimiento.setId(Constantes.TIPO_MOVIMIENTO_CREDITO);
        movimiento.setTipoMovimiento(tipoMovimiento);

        when(movimientoRepository.save(movimientoCaptor.capture())).thenReturn(new Movimiento());
        when(movimientoMapper.toDto(any())).thenReturn(movimiento);

        when(cuentaService.getById(any())).thenReturn(cuenta);
        when(cuentaService.register(cuentaCaptor.capture())).thenReturn(cuenta);

        MovimientoDto resultMovimiento = movimientoService.register(movimiento);
        CuentaDto resultCuenta = cuentaService.register(cuenta);

        assertEquals(cuentaCaptor.getValue().getSaldo(), valorCuentaEsperado);
    }

    @Test
    void guardar_con_saldo_negativo_exception() {

        tipoMovimiento.setId(Constantes.TIPO_MOVIMIENTO_CREDITO);
        movimiento.setTipoMovimiento(tipoMovimiento);

        when(movimientoRepository.save(movimientoCaptor.capture())).thenReturn(new Movimiento());
        when(movimientoMapper.toDto(any())).thenReturn(movimiento);

        when(cuentaService.getById(any())).thenReturn(cuenta);
        when(cuentaService.register(cuentaCaptor.capture())).thenReturn(cuenta);

        MovimientoDto resultMovimiento = movimientoService.register(movimiento);
        CuentaDto resultCuenta = cuentaService.register(cuenta);

        SaldoNoDisponibleException exception = assertThrows(SaldoNoDisponibleException.class, () -> {
            movimientoService.register(movimiento);
        });
    }

}