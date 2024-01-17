package com.example.gestao_vagas.modules.candidates;

import com.example.gestao_vagas.modules.candidates.entities.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {


}
