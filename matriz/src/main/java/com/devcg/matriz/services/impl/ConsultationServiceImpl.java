package com.devcg.matriz.services.impl;

import com.devcg.matriz.dto.ConsultationDTO;
import com.devcg.matriz.entities.Consultation;
import com.devcg.matriz.repositories.ConsultationRepository;
import com.devcg.matriz.services.ConsultationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    private ConsultationRepository repository;

    public ConsultationDTO findById(Long id) {
        Consultation consultation = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Consultation not found"));
        return new ConsultationDTO(consultation);
    }

    public List<ConsultationDTO> findAll() {
        List<Consultation> consultations = repository.findAll();
        return consultations.stream().map(ConsultationDTO::new).collect(Collectors.toList());
    }

    public ConsultationDTO insert(ConsultationDTO dto) {
        Consultation consultation = new Consultation();
        copyDtoToEntity(dto, consultation);
        consultation = repository.save(consultation);
        return new ConsultationDTO(consultation);
    }

    public ConsultationDTO update(Long id, ConsultationDTO dto) {
        try {
            Consultation consultation = repository.getReferenceById(id);
            copyDtoToEntity(dto, consultation);
            consultation = repository.save(consultation);
            return new ConsultationDTO(consultation);

        }
        catch (EntityNotFoundException e) {
            throw new RuntimeException("Consultation not found");
        }
    }

    public void delete(Long id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Consultation not found");
        }
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Database exception");
        }
    }


    private void copyDtoToEntity(ConsultationDTO dto, Consultation consultation) {
        consultation.setPatient(dto.getPatient());
        consultation.setUser(dto.getUser());
        consultation.setPlan(dto.getPlan());
        consultation.setNotes(dto.getNotes());
        consultation.setConsultationDate(dto.getConsultationDate());
        consultation.setPrice(dto.getPrice());
    }
}
