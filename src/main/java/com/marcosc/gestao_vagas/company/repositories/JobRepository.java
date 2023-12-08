package com.marcosc.gestao_vagas.company.repositories;

import com.marcosc.gestao_vagas.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {


}
