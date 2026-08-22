package com.medapp.exam_service.exam;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exams")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping
    public ResponseEntity<ExamResponseDto> createExam(@Valid @RequestBody CreateExamRequestDto request) {
        ExamResponseDto examResponseDto = this.examService.createExam(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(examResponseDto);
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
