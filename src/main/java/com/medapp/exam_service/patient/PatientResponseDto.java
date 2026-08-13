package com.medapp.exam_service.patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String mrn;
    private LocalDate dateOfBirth;
}