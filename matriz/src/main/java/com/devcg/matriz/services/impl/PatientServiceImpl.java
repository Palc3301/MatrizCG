package com.devcg.matriz.services.impl;

import com.devcg.matriz.dto.PatientDTO;
import com.devcg.matriz.entities.Patient;
import com.devcg.matriz.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl {

    @Autowired
    private PatientRepository patientRepository;

    public PatientDTO findById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found"));
        return new PatientDTO(patient);
    }

    public List<PatientDTO> findAll() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(PatientDTO::new).collect(Collectors.toList());
    }

    public PatientDTO insert(PatientDTO dto) {
        Patient patient = new Patient();
        copyDtoToEntity(dto, patient);
        patient = patientRepository.save(patient);
        return new PatientDTO(patient);
    }

    public PatientDTO update(Long id, PatientDTO dto) {
        try {
            Patient patient = patientRepository.getReferenceById(id);
            copyDtoToEntity(dto, patient);
            patient = patientRepository.save(patient);
            return new PatientDTO(patient);
        }
        catch (EntityNotFoundException e) {
            throw new RuntimeException("User not found");
        }
    }

    public void delete(Long id) {
       if (!patientRepository.existsById(id)) {
           throw new RuntimeException("User not found");
       }
        try {
            patientRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Database exception");
        }
    }

    private void copyDtoToEntity(PatientDTO dto, Patient patient) {
        patient.setName(dto.getName());
        patient.setEmail(dto.getEmail());
        patient.setPhone(dto.getPhone());
        patient.setBirthDate(dto.getBirthDate());
        patient.setWeight(dto.getWeight());
    }
}
