package com.github.henriquekikuchi.pontoallv0.service;

import com.github.henriquekikuchi.pontoallv0.entity.ProfessorEntity;
import com.github.henriquekikuchi.pontoallv0.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<ProfessorEntity> getAll(){
        return this.professorRepository.findAll();
    }

    public ProfessorEntity save(ProfessorEntity professor){
        return this.professorRepository.save(professor);
    }

    public ProfessorEntity findById(Long professorId){
        return this.professorRepository.findById(professorId).orElseThrow(RuntimeException::new);
    }

    public ProfessorEntity findByMatricula(Long matricula){
        return this.professorRepository.findByMatricula(matricula).orElseThrow(RuntimeException::new);
    }

    public ProfessorEntity verifyPasswordByMatricula(Long matricula, String password){
        ProfessorEntity professor = this.findByMatricula(matricula);
        if (!professor.getPassword().equals(password)) throw new RuntimeException();
        return professor;
    }

    public ProfessorEntity updateById(Long professorId, ProfessorEntity professorUpdate){
        ProfessorEntity professor = this.findById(professorId);
        professorUpdate.setId(professorId);
        return this.professorRepository.save(professorUpdate);
    }

    public void deleteById(Long professorId){
        this.findById(professorId);
        this.professorRepository.deleteById(professorId);
    }
}
