package com.banco.api.dto;

import lombok.Data;

@Data
public class ClienteDto {

    private Integer id;
    private String nombre;
    private String direccion ;
    private String telefono;
}
