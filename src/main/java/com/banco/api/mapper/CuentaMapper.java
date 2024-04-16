package com.banco.api.mapper;

import com.banco.api.dto.CuentaDto;
import com.banco.api.entity.Cuenta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CuentaMapper extends GenericMapper<Cuenta, CuentaDto> {
}
