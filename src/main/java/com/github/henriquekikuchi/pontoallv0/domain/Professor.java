package com.github.henriquekikuchi.pontoallv0.domain;

import com.github.henriquekikuchi.pontoallv0.dto.RegistroDePontoAgregadoDto;
import com.github.henriquekikuchi.pontoallv0.entity.RegistroDePontoEntity;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Professor {
    private long id;
    private String nome;
    private String materia;
    private long matricula;
    private String password;
    private List<RegistroDePontoEntity> registros;

    public List<RegistroDePontoAgregadoDto> RegistrosDePontoDiaDia(){
        var registros = this.registros.stream()
                .collect(groupingBy(RegistroDePontoEntity::getDataDoRegistro, collectingAndThen(
                        toList(), registroDePontoEntities -> {

                            long minutes = 0;

                            LocalDateTime min = registroDePontoEntities.stream()
                                    .min((o1, o2) -> o1.getDataHoraDoRegistro().compareTo(o2.getDataHoraDoRegistro()))
                                    .map(RegistroDePontoEntity::getDataHoraDoRegistro)
                                    .orElse(null);

                            LocalDateTime max = registroDePontoEntities.stream()
                                    .max((o1, o2) -> o1.getDataHoraDoRegistro().compareTo(o2.getDataHoraDoRegistro()))
                                    .map(RegistroDePontoEntity::getDataHoraDoRegistro)
                                    .orElse(null);

                            if (min != null && max != null)
                                minutes = Duration.between(min, max).toMinutes();

                            return new RegistroDePontoAgregado(min, max, (int) minutes);
                        }
                ))).entrySet()
                .stream()
                .map(entry -> new RegistroDePontoAgregadoDto(entry.getKey(), entry.getValue()))
                .toList();
        return registros;
    }
}
