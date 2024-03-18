package com.devcg.matriz.entities;

import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "tb_consultation")
public class Consultation {
    private Long id;
    private LocalDateTime data;
    private String Status;
    private Patient patient;
    private String notes;

}
