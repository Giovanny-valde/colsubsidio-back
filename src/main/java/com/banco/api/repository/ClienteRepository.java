package com.banco.api.repository;

import com.banco.api.dto.Reporte;
import com.banco.api.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("""
            SELECT
            cu AS cuenta,
            c AS cliente,
            SUM(CASE WHEN tipoMovimiento.id = 1 THEN 1 ELSE 0 END) AS credito,
            SUM(CASE WHEN tipoMovimiento.id = 2 THEN 1 ELSE 0 END) AS debito
            FROM Cliente c
            INNER JOIN Cuenta cu ON cu.cliente.id = c.id
            INNER JOIN Movimiento m ON m.cuenta.id = cu.id
            WHERE c.id = ?1
            AND m.fecha BETWEEN ?2 AND ?3
            GROUP BY
            cu, c""")
    List<Reporte> findByClienteAndFecha(Integer id, LocalDateTime fechaStart, LocalDateTime fechaEnd);
}