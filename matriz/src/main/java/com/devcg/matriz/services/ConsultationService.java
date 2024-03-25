package com.devcg.matriz.services;

import com.devcg.matriz.dto.ConsultationDTO;
import com.devcg.matriz.dto.PatientDTO;
import com.devcg.matriz.entities.Consultation;
import com.devcg.matriz.entities.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsultationService {
    ConsultationDTO findById(Long id);

    List<ConsultationDTO> findAll();

    ConsultationDTO insert(ConsultationDTO dto);

    ConsultationDTO update(Long id, ConsultationDTO dto);

    void delete(Long id);
}
