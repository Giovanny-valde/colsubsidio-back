package com.banco.api.mapper;

import com.banco.api.dto.ClienteDto;
import com.banco.api.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends GenericMapper<Cliente, ClienteDto> {
}
