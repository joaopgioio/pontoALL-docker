package com.github.henriquekikuchi.pontoallv0.controller;


import com.github.henriquekikuchi.pontoallv0.converter.ProfessorMapper;
import com.github.henriquekikuchi.pontoallv0.domain.Professor;
import com.github.henriquekikuchi.pontoallv0.dto.ProfessorCreateDto;
import com.github.henriquekikuchi.pontoallv0.dto.RegistroDePontoCreateDto;
import com.github.henriquekikuchi.pontoallv0.entity.ProfessorEntity;
import com.github.henriquekikuchi.pontoallv0.entity.RegistroDePontoEntity;
import com.github.henriquekikuchi.pontoallv0.service.ProfessorService;
import com.github.henriquekikuchi.pontoallv0.service.RegistroDePontoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/registros")
@RequiredArgsConstructor
@CrossOrigin
public class RegistroDePontoController {

    private final RegistroDePontoService registroDePontoService;
    private final ProfessorService professorService;

    @PostMapping
    public ResponseEntity<RegistroDePontoEntity> saveRegistroDePonto(
            @RequestBody RegistroDePontoCreateDto registroDePontoCreateDto) {

        Long matricula = registroDePontoCreateDto.getMatricula();
        String password = registroDePontoCreateDto.getPassword();
        ProfessorEntity professor = this.professorService.verifyPasswordByMatricula(matricula, password);
        RegistroDePontoEntity registroDePonto = RegistroDePontoEntity.builder()
                .professor(professor)
                .dataDoRegistro(LocalDate.now())
                .dataHoraDoRegistro(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(this.registroDePontoService.save(registroDePonto), HttpStatus.CREATED);
    }

    @GetMapping("/professor/{idProfessor}")
    public ResponseEntity getRegistroDePontoDiaDiaByProfessorId(@PathVariable("idProfessor") Long id){
        ProfessorEntity professorEntity = professorService.findById(id);
        Professor professor = ProfessorMapper.INSTANCE.fromProfessorEntityToProfessor(professorEntity);
        return ResponseEntity.ok(professor.RegistrosDePontoDiaDia());
    }
}
