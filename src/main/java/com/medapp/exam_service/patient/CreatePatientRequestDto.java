package com.medapp.exam_service.patient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

/**
 * DTO to receive patient data from the HTTP request
 */
@Data
public class CreatePatientRequestDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String mrn;

    @Past
    private LocalDate dateOfBirth;
}
