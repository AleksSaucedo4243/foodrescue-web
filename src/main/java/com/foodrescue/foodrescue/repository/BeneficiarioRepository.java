package com.foodrescue.foodrescue.repository;

import com.foodrescue.foodrescue.model.entity.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
}