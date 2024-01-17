package com.example.gestao_vagas.modules.candidates.userCases;

import com.example.gestao_vagas.modules.candidates.CandidateRepository;
import com.example.gestao_vagas.modules.candidates.entities.CandidateEntity;
import com.example.gestao_vagas.modules.exceptions.UserFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateCandidateUserCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundExceptions();
                });
        return this.candidateRepository.save(candidateEntity);
    }
}
