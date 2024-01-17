package com.example.gestao_vagas.modules.exceptions;

public class UserFoundExceptions extends RuntimeException {
    public UserFoundExceptions() {
        super("Usuário já existe!");
    }
}
