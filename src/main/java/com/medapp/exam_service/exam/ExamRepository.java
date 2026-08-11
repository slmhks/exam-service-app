package com.medapp.exam_service.exam;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam,Long> {

    List<Exam> findByStatus(ExamStatus status);

    List<Exam> findByPatientId(Long patientId);

}
