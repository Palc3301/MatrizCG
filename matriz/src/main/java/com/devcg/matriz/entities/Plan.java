package com.devcg.matriz.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tb_plan")
public class Plan {
    private Long id;
    private String planType;
}
