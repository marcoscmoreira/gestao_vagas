package com.marcosc.gestao_vagas.company.services;

import com.marcosc.gestao_vagas.company.entities.CompanyEntity;
import com.marcosc.gestao_vagas.company.repositories.CompanyRepository;
import com.marcosc.gestao_vagas.exceptions.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute (CompanyEntity companyEntity) {

        this.companyRepository.findByuserNameOrEmail(companyEntity.getUserName(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.companyRepository.save(companyEntity);

    }

}
