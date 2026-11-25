package com.foodrescue.foodrescue.repository;

import com.foodrescue.foodrescue.model.entity.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonacionRepository extends JpaRepository<Donacion, Long> {
}