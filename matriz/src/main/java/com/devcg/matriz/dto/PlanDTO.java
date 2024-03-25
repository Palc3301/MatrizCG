package com.devcg.matriz.dto;

import com.devcg.matriz.entities.Plan;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanDTO {
    private Long id;

    @NotBlank(message = "Campo requerido")
    private Double price;

    @NotBlank(message = "Tipo de plano precisa ser informado os meses de duração(EX: 3 meses)")
    private String planType;

    public PlanDTO(Plan plan) {
        this.id = plan.getId();
        this.price = plan.getPrice();
        this.planType = plan.getPlanType();
    }
}
