package com.marcosc.gestao_vagas.company.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.marcosc.gestao_vagas.company.dto.AuthCompanyDTO;
import com.marcosc.gestao_vagas.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AuthCompanyUseCase {

    @Value("${securit.token.secret}")
    private String secretKey;
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute (AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company  = this.companyRepository.findByUserName(authCompanyDTO.getUsername())
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("Company Not Found");
                } );

        // Verificar se a senha é igual
        var passwordMatches = passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        // Se não for igual -> erro
        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        // Se For igual -> Gerar Token

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        var token = JWT.create().withIssuer("javagas")
                .withSubject(company.getId().toString())
                .sign(algorithm);

        return token;

    }

}
