package com.banco.api.controller;

import com.banco.api.dto.CuentaDto;
import com.banco.api.service.CuentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("cuentas")
public class CuentaController {

    private final CuentaService service;

    @GetMapping
    public ResponseEntity<List<CuentaDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<CuentaDto> register(@Valid  @RequestBody CuentaDto cuenta) {
        return new ResponseEntity<>(service.register(cuenta), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CuentaDto> update(@Valid @RequestBody CuentaDto cuenta) {
        return ResponseEntity.ok(service.update(cuenta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
