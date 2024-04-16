package com.banco.api.controller;

import com.banco.api.dto.TipoMovimientoDto;
import com.banco.api.service.TipoMovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("tipos-movimiento")
public class TipoMovimientoController {

    private final TipoMovimientoService service;

    @GetMapping
    public ResponseEntity<List<TipoMovimientoDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
