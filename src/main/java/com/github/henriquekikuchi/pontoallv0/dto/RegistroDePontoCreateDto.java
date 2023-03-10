package com.github.henriquekikuchi.pontoallv0.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroDePontoCreateDto {

    private Long matricula;
    private String password;
}
