package com.medapp.exam_service.exam;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.medapp.exam_service.modality.Modality;
import com.medapp.exam_service.patient.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "exams")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    @ToString.Exclude
    @JsonBackReference
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modality_id", nullable = false)
    @ToString.Exclude
    private Modality modality;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExamStatus status;

    private String examType; // e.g. "CT_HEAD, "MRI_KNEE", "XRAY_CHEST"
    private LocalDateTime arrivedAt;
    private LocalDateTime checkedInAt;
    private LocalDateTime roomEntryAt;
    private LocalDateTime examStartedAt;
    private LocalDateTime imagesCapturedAt;
    private LocalDateTime completedAt;

}
