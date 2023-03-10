package com.github.henriquekikuchi.pontoallv0.repository;

import com.github.henriquekikuchi.pontoallv0.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {

    Optional<ProfessorEntity> findByMatricula(Long matricula);
}
