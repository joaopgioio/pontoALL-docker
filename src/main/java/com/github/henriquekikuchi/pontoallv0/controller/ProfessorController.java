package com.github.henriquekikuchi.pontoallv0.controller;


import com.github.henriquekikuchi.pontoallv0.converter.ProfessorMapper;
import com.github.henriquekikuchi.pontoallv0.dto.ProfessorCreateDto;
import com.github.henriquekikuchi.pontoallv0.entity.ProfessorEntity;
import com.github.henriquekikuchi.pontoallv0.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/professores")
@RequiredArgsConstructor
@CrossOrigin
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorEntity>> getAllProfessores(){
        return ResponseEntity.ok(professorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorEntity> getProfessorById(@PathVariable("id") Long id){
        return ResponseEntity.ok(professorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProfessorEntity> saveProfessor(@RequestBody ProfessorCreateDto professorCreateDto){
        ProfessorEntity professor = ProfessorMapper.INSTANCE.fromProfessorCreateDto(professorCreateDto);
        return new ResponseEntity<>(this.professorService.save(professor), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorEntity> updateProfessor(
            @PathVariable("id") Long id,
            @RequestBody ProfessorCreateDto professorCreateDto){
        ProfessorEntity professor = ProfessorMapper.INSTANCE.fromProfessorCreateDto(professorCreateDto);
        return new ResponseEntity<>(this.professorService.updateById(id, professor), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable("id") Long id){
        professorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
