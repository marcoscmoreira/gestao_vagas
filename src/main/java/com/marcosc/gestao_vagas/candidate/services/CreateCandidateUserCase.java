package com.marcosc.gestao_vagas.candidate.services;

import com.marcosc.gestao_vagas.candidate.controllers.CandidateEntity;
import com.marcosc.gestao_vagas.candidate.controllers.CandidateRepository;
import com.marcosc.gestao_vagas.exceptions.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUserCase {

    @Autowired
    private CandidateRepository candidateRepository;
    public CandidateEntity execute (CandidateEntity candidateEntity) {
        this.candidateRepository
                .findByuserNameOrEmail(candidateEntity.getUserName(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });


        return this.candidateRepository.save(candidateEntity);
    }





}
