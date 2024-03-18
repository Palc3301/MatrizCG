package com.devcg.matriz.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Table(name = "tb_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private String paymentType;
}
