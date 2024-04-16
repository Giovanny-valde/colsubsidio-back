package com.banco.api.mapper;

import java.util.List;

public interface GenericMapper<T, D>  {

    T toEntity(D dto);
    D toDto(T enety);
    List<T> toEntities(List<D> dtos);
    List<D> toDtos(List<T> entities);
}
