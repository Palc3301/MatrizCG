package com.devcg.matriz.controllers;

import com.devcg.matriz.dto.PatientDTO;
import com.devcg.matriz.services.PatientService;
import com.devcg.matriz.services.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable Long id) {
        PatientDTO dto = patientService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> findAll() {
        List<PatientDTO> patients = patientService.findAll();
        return ResponseEntity.ok(patients);
    }

    @PostMapping
    public ResponseEntity<PatientDTO> insert(@RequestBody PatientDTO dto) {
        dto = patientService.insert(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping
    public ResponseEntity<PatientDTO> update(@PathVariable Long id, @RequestBody PatientDTO dto) {
        dto = patientService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(Long id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
