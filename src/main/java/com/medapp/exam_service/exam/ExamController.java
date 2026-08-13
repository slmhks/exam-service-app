package com.medapp.exam_service.exam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exams")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/{examId}/check-in")
    public ResponseEntity<Exam> checkIn(@PathVariable Long examId) {
        Exam updated = this.examService.checkIn(examId);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/{examId}/enter-room")
    public ResponseEntity<Exam> enterRoom(@PathVariable Long examId) {
        Exam updated = this.examService.enterRoom(examId);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/{examId}/start")
    public ResponseEntity<Exam> startExam(@PathVariable Long examId) {
        Exam updated = this.examService.startExam(examId);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/{examId}/images-captured")
    public ResponseEntity<Exam> markImagesCaptured(@PathVariable Long examId) {
        Exam updated = this.examService.markImagesCaptured(examId);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/{examId}/complete")
    public ResponseEntity<Exam> completeExam(@PathVariable Long examId) {
        Exam updated = this.examService.completeExam(examId);
        return ResponseEntity.ok(updated);
    }
}
