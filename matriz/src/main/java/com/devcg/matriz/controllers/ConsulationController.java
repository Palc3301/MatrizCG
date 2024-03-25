package com.devcg.matriz.controllers;

import com.devcg.matriz.dto.ConsultationDTO;
import com.devcg.matriz.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultations")
public class ConsulationController {

    @Autowired
    private ConsultationService consultationService;

    @GetMapping("/{id}")
    public ResponseEntity<ConsultationDTO> findById(@PathVariable Long id) {
        ConsultationDTO dto = consultationService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ConsultationDTO>> findAll() {
        List<ConsultationDTO> consultations = consultationService.findAll();
        return ResponseEntity.ok(consultations);
    }

    @PostMapping
    public ResponseEntity<ConsultationDTO> insert(@RequestBody ConsultationDTO dto) {
        dto = consultationService.insert(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultationDTO> update(@PathVariable Long id, @RequestBody ConsultationDTO dto) {
        dto = consultationService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        consultationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
