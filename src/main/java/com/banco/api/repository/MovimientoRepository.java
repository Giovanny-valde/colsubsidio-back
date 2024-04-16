package com.banco.api.repository;

import com.banco.api.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
    @Query("" +
            "select m from Movimiento m where m.cuenta.cliente.id = ?1 and m.fecha between ?2 and ?3" +
            "")
    List<Movimiento> findByCuentaAndFecha(Integer id, LocalDateTime fechaStart, LocalDateTime fechaEnd);

}