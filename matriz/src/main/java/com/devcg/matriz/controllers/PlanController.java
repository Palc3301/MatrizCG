package com.devcg.matriz.controllers;

import com.devcg.matriz.dto.PlanDTO;
import com.devcg.matriz.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping("/{id}")
    public ResponseEntity<PlanDTO> findById(@PathVariable Long id) {
        PlanDTO dto = planService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<PlanDTO>> findAll() {
        List<PlanDTO> plans = planService.findAll();
        return ResponseEntity.ok(plans);
    }

    @PostMapping
    public ResponseEntity<PlanDTO> insert(@RequestBody PlanDTO dto) {
        dto = planService.insert(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanDTO> update(@PathVariable Long id, @RequestBody PlanDTO dto) {
        dto = planService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        planService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
