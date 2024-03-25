package com.devcg.matriz.services;

import com.devcg.matriz.dto.PatientDTO;
import com.devcg.matriz.entities.Patient;
import com.devcg.matriz.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

        PatientDTO findById(Long id);

        List<PatientDTO> findAll();

        PatientDTO insert(PatientDTO dto);

        PatientDTO update(Long id, PatientDTO dto);

        void delete(Long id);

}
