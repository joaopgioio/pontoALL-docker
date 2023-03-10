package com.github.henriquekikuchi.pontoallv0.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorCreateDto {
    private String nome;
    private String materia;
    private long matricula;
    private String password;
}
