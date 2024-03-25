package com.devcg.matriz.services;

import com.devcg.matriz.dto.PlanDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanService {

    PlanDTO findById(Long id);

    List<PlanDTO> findAll();

    PlanDTO insert(PlanDTO dto);

    PlanDTO update(Long id, PlanDTO dto);

    void delete(Long id);
}
