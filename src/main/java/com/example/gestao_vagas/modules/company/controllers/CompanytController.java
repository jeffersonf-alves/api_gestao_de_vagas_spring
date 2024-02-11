package com.example.gestao_vagas.modules.company.controllers;


import com.example.gestao_vagas.modules.company.entities.CompanyEntity;
import com.example.gestao_vagas.modules.company.useCases.CreateCompanyUseCases;
import com.example.gestao_vagas.modules.exceptions.UserFoundExceptions;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanytController {

    @Autowired
    private CreateCompanyUseCases createCompanyUseCases;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
        try {
            var result = this.createCompanyUseCases.execute(companyEntity);
            return ResponseEntity.ok().body(result);
        } catch (UserFoundExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
