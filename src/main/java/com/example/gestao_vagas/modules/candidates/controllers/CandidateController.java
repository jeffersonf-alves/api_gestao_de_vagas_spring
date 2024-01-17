package com.example.gestao_vagas.modules.candidates.controllers;


import com.example.gestao_vagas.modules.candidates.CandidateRepository;
import com.example.gestao_vagas.modules.candidates.entities.CandidateEntity;
import com.example.gestao_vagas.modules.candidates.userCases.CreateCandidateUserCase;
import com.example.gestao_vagas.modules.exceptions.UserFoundExceptions;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateUserCase createCandidateUserCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidate) {
        try {
            var result = this.createCandidateUserCase.execute(candidate);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
