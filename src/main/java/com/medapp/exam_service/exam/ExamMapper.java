package com.medapp.exam_service.exam;

import com.medapp.exam_service.modality.Modality;
import com.medapp.exam_service.modality.ModalityMapper;
import com.medapp.exam_service.patient.Patient;
import com.medapp.exam_service.patient.PatientMapper;

import java.time.LocalDateTime;

public class ExamMapper {

    public static Exam toEntity(CreateExamRequestDto request, Patient patient, Modality modality) {
        Exam exam = new Exam();
        exam.setPatient(patient);
        exam.setModality(modality);
        exam.setExamType(request.getExamType());
        exam.setStatus(ExamStatus.ARRIVED);
        exam.setArrivedAt(LocalDateTime.now());
        return exam;
    }

    public static ExamResponseDto toResponse(Exam exam) {
        return ExamResponseDto.builder()
                .id(exam.getId())
                .patient(PatientMapper.toResponse(exam.getPatient()))
                .modality(ModalityMapper.toResponse(exam.getModality()))
                .status(exam.getStatus())
                .examType(exam.getExamType())
                .arrivedAt(exam.getArrivedAt())
                .checkedInAt(exam.getCheckedInAt())
                .roomEntryAt(exam.getRoomEntryAt())
                .examStartedAt(exam.getExamStartedAt())
                .imagesCapturedAt(exam.getImagesCapturedAt())
                .completedAt(exam.getCompletedAt())
                .build();
    }
}
