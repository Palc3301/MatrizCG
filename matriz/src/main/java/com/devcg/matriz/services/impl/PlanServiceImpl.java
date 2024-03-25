package com.devcg.matriz.services.impl;

import com.devcg.matriz.dto.PlanDTO;
import com.devcg.matriz.entities.Plan;
import com.devcg.matriz.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanServiceImpl {

    @Autowired
    private PlanRepository planRepository;

    public PlanDTO findById(Long id) {
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Plan not found"));
        return new PlanDTO(plan);

    }

    public List<PlanDTO> findAll() {
        List<Plan> plans = planRepository.findAll();
        return plans.stream().map(PlanDTO::new).collect(Collectors.toList());
    }

    public PlanDTO insert(PlanDTO dto) {
        Plan plan = new Plan();
        copyDtoToEntity(dto, plan);
        plan = planRepository.save(plan);
        return new PlanDTO(plan);
    }

    public PlanDTO update(Long id, PlanDTO dto) {
        try {
            Plan plan = planRepository.getReferenceById(id);
            copyDtoToEntity(dto, plan);
            plan = planRepository.save(plan);
            return new PlanDTO(plan);
        }
        catch (Exception e) {
            throw new RuntimeException("Plan not found");
        }
    }

    public void delete(Long id) {
        if(!planRepository.existsById(id)) {
            throw new RuntimeException("Plan not found");
        }
        try {
            planRepository.deleteById(id);
        }
        catch (Exception e) {
            throw new RuntimeException("Plan not found");
        }
    }

    private void copyDtoToEntity(PlanDTO dto, Plan entity) {
        entity.setPrice(dto.getPrice());
        entity.setPlanType(dto.getPlanType());
    }
}
