package com.devcg.matriz.entities;

import com.devcg.matriz.entities.enums.ConsultationsStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "tb_consultation")
@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ConsultationsStatus status;

    @ManyToOne
    @JsonIgnoreProperties
    private Patient patient;

    @ManyToOne
    @JsonIgnoreProperties
    private User user;

    @ManyToOne
    @JsonIgnoreProperties
    private Plan plan;

    private String notes;

    private LocalDateTime consultationDate;

    private Double price;
}
