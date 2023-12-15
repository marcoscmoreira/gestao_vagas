package com.marcosc.gestao_vagas.candidate.services;

import com.marcosc.gestao_vagas.candidate.controllers.CandidateEntity;
import com.marcosc.gestao_vagas.candidate.controllers.CandidateRepository;
import com.marcosc.gestao_vagas.exceptions.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUserCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute (CandidateEntity candidateEntity) {
        this.candidateRepository
                .findByuserNameOrEmail(candidateEntity.getUserName(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        /* Realiza a criptografia da senha do candidato */
        var password = passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(password);


        return this.candidateRepository.save(candidateEntity);
    }





}
