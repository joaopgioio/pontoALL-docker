package com.github.henriquekikuchi.pontoallv0.converter;

import com.github.henriquekikuchi.pontoallv0.domain.Professor;
import com.github.henriquekikuchi.pontoallv0.dto.ProfessorCreateDto;
import com.github.henriquekikuchi.pontoallv0.entity.ProfessorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfessorMapper {

    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

    ProfessorEntity fromProfessorCreateDto(ProfessorCreateDto professorCreateDto);
    Professor fromProfessorEntityToProfessor(ProfessorEntity professorEntity);
}
