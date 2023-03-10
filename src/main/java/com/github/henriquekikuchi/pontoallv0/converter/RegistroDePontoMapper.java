package com.github.henriquekikuchi.pontoallv0.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegistroDePontoMapper {

    RegistroDePontoMapper INSTANCE = Mappers.getMapper(RegistroDePontoMapper.class);


}
