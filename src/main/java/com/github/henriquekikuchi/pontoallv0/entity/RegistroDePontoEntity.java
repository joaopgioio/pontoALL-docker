package com.github.henriquekikuchi.pontoallv0.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroDePontoEntity {

    @Id
    @GeneratedValue(generator = "seq_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="seq_generator", sequenceName = "SEQ_REGISTRO_PONTO_ENTITY", initialValue = 11, allocationSize=1)
    private long id;
    @DateTimeFormat
    private LocalDateTime dataHoraDoRegistro;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDoRegistro;
    @ManyToOne(targetEntity = ProfessorEntity.class, optional = false)
    @JsonBackReference
    private ProfessorEntity professor;
}
