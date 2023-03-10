package com.github.henriquekikuchi.pontoallv0.dto;

import com.github.henriquekikuchi.pontoallv0.domain.RegistroDePontoAgregado;

import java.time.LocalDate;

public record RegistroDePontoAgregadoDto(
        LocalDate data,
        RegistroDePontoAgregado registroDePontoAgregado
) {
}
