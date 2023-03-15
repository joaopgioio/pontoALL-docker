package com.github.henriquekikuchi.pontoallv0.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessorEntity {

    @Id
    @GeneratedValue(generator = "seq_generator_professor", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="seq_generator_professor", sequenceName = "SEQ_PROFESSOR_ENTITY", initialValue = 9, allocationSize=1)
    private long id;

    private String nome;

    private String materia;

    @Column(unique = true)
    private long matricula;

    private String password;

    @OneToMany(targetEntity = RegistroDePontoEntity.class, mappedBy = "professor", orphanRemoval = true)
    @JsonManagedReference
    private List<RegistroDePontoEntity> registros;
}
