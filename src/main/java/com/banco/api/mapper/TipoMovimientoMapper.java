package com.banco.api.mapper;

import com.banco.api.dto.TipoMovimientoDto;
import com.banco.api.entity.TipoMovimiento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoMovimientoMapper extends GenericMapper<TipoMovimiento, TipoMovimientoDto>{


}
