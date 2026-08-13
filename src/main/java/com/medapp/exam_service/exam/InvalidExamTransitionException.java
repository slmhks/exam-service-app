package com.medapp.exam_service.exam;

public class InvalidExamTransitionException extends RuntimeException {
    public InvalidExamTransitionException(ExamStatus current, ExamStatus target) {
        super("Cannot transition exam from " + current + " to " + target + " - invalid workflow sequence");
    }
}
