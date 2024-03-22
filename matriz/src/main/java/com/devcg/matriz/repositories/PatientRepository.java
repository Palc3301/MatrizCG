package com.devcg.matriz.repositories;

import com.devcg.matriz.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
