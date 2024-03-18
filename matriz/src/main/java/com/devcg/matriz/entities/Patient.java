package com.devcg.matriz.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private String birthDate;
    private String weight;
}
