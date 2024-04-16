package com.banco.api.mapper;

import com.banco.api.dto.MovimientoDto;
import com.banco.api.entity.Movimiento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovimientoMapper extends GenericMapper<Movimiento, MovimientoDto>{
}
