package com.marcosc.gestao_vagas.company.repositories;

import com.marcosc.gestao_vagas.company.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity> findByuserNameOrEmail (String Username, String email);
}
