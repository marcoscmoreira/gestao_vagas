package com.marcosc.gestao_vagas.company.controller;

import com.marcosc.gestao_vagas.company.dto.AuthCompanyDTO;
import com.marcosc.gestao_vagas.company.services.AuthCompanyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class AuthCompanyController {

    @Autowired
    private AuthCompanyUseCase authCompanyUseCase;

    @PostMapping("/company")
    public String create (@RequestBody AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        return this.authCompanyUseCase.execute(authCompanyDTO);
    }


}
