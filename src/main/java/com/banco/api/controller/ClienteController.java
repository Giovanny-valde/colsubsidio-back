package com.banco.api.controller;

import com.banco.api.dto.ClienteDto;
import com.banco.api.dto.Reporte;
import com.banco.api.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClienteDto> register(@Valid @RequestBody ClienteDto cliente) {
        return new ResponseEntity<>(service.register(cliente), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ClienteDto> update(@Valid @RequestBody ClienteDto cliente) {
        return ResponseEntity.ok(service.update(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/reporte")
    public ResponseEntity<List<Reporte>> findByClienteAndFecha(@RequestParam  Integer id,
                                                               @RequestParam LocalDateTime fechaStart,
                                                               @RequestParam  LocalDateTime fechaEnd) {
        return ResponseEntity.ok(service.findByClienteAndFecha(id, fechaStart, fechaEnd));
    }
}
