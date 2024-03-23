package com.devcg.matriz.dto;

import com.devcg.matriz.entities.Patient;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Long id;

    @Size(min = 3, max = 80, message = "Nome precisar ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;

    @NotBlank(message = "Campo requerido")
    private String email;

    @NotBlank(message = "Campo requerido")
    private String phone;

    @NotBlank(message = "Campo requerido")
    private String birthDate;

    @NotBlank(message = "Campo requerido")
    private String weight;

    public PatientDTO(Patient patient) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.weight = weight;
    }
}
