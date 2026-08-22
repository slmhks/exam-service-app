package com.medapp.exam_service.exam;

import com.medapp.exam_service.modality.ModalityResponseDto;
import com.medapp.exam_service.patient.PatientResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamResponseDto {

    private Long id;
    private PatientResponseDto patient;
    private ModalityResponseDto modality;
    private ExamStatus status;
    private String examType;
    private LocalDateTime arrivedAt;
    private LocalDateTime checkedInAt;
    private LocalDateTime roomEntryAt;
    private LocalDateTime examStartedAt;
    private LocalDateTime imagesCapturedAt;
    private LocalDateTime completedAt;

}
