package com.github.henriquekikuchi.pontoallv0.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RegistroDePontoAgregado(
        LocalDateTime dateTimeEntrada,
        LocalDateTime dateTimeSaida,
        int somaMinutos
) {
}
