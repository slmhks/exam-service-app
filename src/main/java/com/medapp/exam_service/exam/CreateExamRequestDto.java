package com.medapp.exam_service.exam;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateExamRequestDto {

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    @NotNull(message = "Modality ID is required")
    private Long modalityId;

    @NotBlank(message = "Exam type is required")
    private String examType;
}
