package com.marcosc.gestao_vagas.exceptions;

public class UserFoundException extends RuntimeException{
     /*Classe usar extenção do Runtime Exception para lançar uma
     exceção amigavel para o usuário*/
    public UserFoundException () {
        super("Usuário já existe");
    }

}
