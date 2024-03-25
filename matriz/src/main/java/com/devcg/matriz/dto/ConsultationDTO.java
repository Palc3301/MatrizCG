package com.devcg.matriz.dto;

import com.devcg.matriz.entities.Consultation;
import com.devcg.matriz.entities.Patient;
import com.devcg.matriz.entities.Plan;
import com.devcg.matriz.entities.User;
import com.devcg.matriz.entities.enums.ConsultationsStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationDTO {

    private Long id;

    private ConsultationsStatus status;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Ignora propriedades específicas durante a desserialização
    private Patient patient;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Plan plan;

    @Size(min = 3, max = 80, message = "Notas da consulta precisam ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String notes;

    private LocalDateTime consultationDate;

    @NotBlank(message = "Campo requerido")
    private Double price;

    public ConsultationDTO(Consultation consultation) {
        this.id = consultation.getId();
        this.status = consultation.getStatus();
        this.patient = consultation.getPatient();
        this.user = consultation.getUser();
        this.plan = consultation.getPlan();
        this.notes = consultation.getNotes();
        this.consultationDate = consultation.getConsultationDate();
        this.price = consultation.getPrice();
    }
}
