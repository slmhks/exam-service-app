package com.medapp.exam_service.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    @Autowired
    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public Exam checkIn(Long examId) {
        Exam exam = getExamOrThrow(examId);
        validateTransition(exam.getStatus(), ExamStatus.ARRIVED, ExamStatus.CHECKED_IN);

        exam.setStatus(ExamStatus.CHECKED_IN);
        exam.setCheckedInAt(LocalDateTime.now());
        return examRepository.save(exam);
    }

    public Exam enterRoom(Long examId) {
        Exam exam = getExamOrThrow(examId);
        validateTransition(exam.getStatus(), ExamStatus.CHECKED_IN, ExamStatus.IN_ROOM);

        exam.setStatus(ExamStatus.IN_ROOM);
        exam.setRoomEntryAt(LocalDateTime.now());
        return examRepository.save(exam);
    }

    public Exam startExam(Long examId) {
        Exam exam = getExamOrThrow(examId);
        validateTransition(exam.getStatus(), ExamStatus.IN_ROOM, ExamStatus.IN_PROGRESS);

        exam.setStatus(ExamStatus.IN_PROGRESS);
        exam.setExamStartedAt(LocalDateTime.now());
        return examRepository.save(exam);
    }

    public Exam markImagesCaptured(Long examId) {
        Exam exam = getExamOrThrow(examId);
        validateTransition(exam.getStatus(), ExamStatus.IN_PROGRESS, ExamStatus.IMAGES_CAPTURED);

        exam.setStatus(ExamStatus.IMAGES_CAPTURED);
        exam.setImagesCapturedAt(LocalDateTime.now());
        return examRepository.save(exam);
    }

    public Exam completeExam(Long examId) {
        Exam exam = getExamOrThrow(examId);
        validateTransition(exam.getStatus(), ExamStatus.IMAGES_CAPTURED, ExamStatus.COMPLETED);

        exam.setStatus(ExamStatus.COMPLETED);
        exam.setCompletedAt(LocalDateTime.now());
        return examRepository.save(exam);
    }

    private Exam getExamOrThrow(Long examId) {
        return examRepository.findById(examId).orElseThrow(() ->
                new ExamNotFoundException(examId));
    }

    private void validateTransition(ExamStatus current, ExamStatus expected, ExamStatus target) {
        if (current != expected) {
            throw new InvalidExamTransitionException(current, target);
        }
    }
}
