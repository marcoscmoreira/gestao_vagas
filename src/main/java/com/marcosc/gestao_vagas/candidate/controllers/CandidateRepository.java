package com.marcosc.gestao_vagas.candidate.controllers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity , UUID> {
    /*Passando um Optional para o JPA utilizando a nomenclatura do JPA ele entende
    o que o Sql irá fazer*/

    // Optiona irá executar um sql para busca do username ou o email
    Optional<CandidateEntity> findByuserNameOrEmail (String Username, String email);


}
