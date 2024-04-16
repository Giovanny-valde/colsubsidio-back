package com.banco.api.controller;

import com.banco.api.dto.MovimientoDto;
import com.banco.api.service.MovimientoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("movimientos")
public class MovimientoController {

    private final MovimientoService service;

    @PostMapping
    public ResponseEntity<MovimientoDto> register(@Valid @RequestBody MovimientoDto movimiento) {
        return new ResponseEntity<>(service.register(movimiento), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MovimientoDto>> findByCuentaAndFecha(@RequestParam  Integer id,
                                                                     @RequestParam  LocalDateTime fechaStart,
                                                                     @RequestParam  LocalDateTime fechaEnd) {
        return ResponseEntity.ok(service.findByCuentaAndFecha(id, fechaStart, fechaEnd));
    }
}