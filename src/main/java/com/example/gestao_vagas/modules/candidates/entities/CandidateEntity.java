package com.example.gestao_vagas.modules.candidates.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;

    @Pattern(regexp = "^(?!\\s*$).+", message = "O Campo não deve conter espaço!")
    private String username;

    @Email(message = "O campo deve conter um e-mail válido!")
    private String email;

    @Length(min = 10, max = 100)
    private String password;
    private String description;
    private String curriculum;

}
