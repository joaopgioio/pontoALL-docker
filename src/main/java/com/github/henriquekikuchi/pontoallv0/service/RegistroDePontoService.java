package com.github.henriquekikuchi.pontoallv0.service;

import com.github.henriquekikuchi.pontoallv0.entity.ProfessorEntity;
import com.github.henriquekikuchi.pontoallv0.entity.RegistroDePontoEntity;
import com.github.henriquekikuchi.pontoallv0.repository.RegistroDePontoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroDePontoService {

    private final RegistroDePontoRepository registroDePontoRepository;

    public List<RegistroDePontoEntity> getAll(){
        return this.registroDePontoRepository.findAll();
    }

    public RegistroDePontoEntity save(RegistroDePontoEntity registroDePonto){
        return this.registroDePontoRepository.save(registroDePonto);
    }

    public RegistroDePontoEntity findById(Long registroDePontoId){
        return this.registroDePontoRepository.findById(registroDePontoId).orElseThrow(RuntimeException::new);
    }

    public RegistroDePontoEntity updateById(Long registroDePontoId, RegistroDePontoEntity registroDePontoUpdate){
        RegistroDePontoEntity registroDePonto = this.findById(registroDePontoId);
        registroDePontoUpdate.setId(registroDePontoId);
        return this.registroDePontoRepository.save(registroDePontoUpdate);
    }

    public void deleteById(Long registroDePontoId){
        this.registroDePontoRepository.deleteById(registroDePontoId);
    }
}
