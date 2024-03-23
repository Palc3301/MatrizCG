package com.devcg.matriz.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_plan")
@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private String planType;
}
