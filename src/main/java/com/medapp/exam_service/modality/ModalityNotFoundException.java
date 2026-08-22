package com.medapp.exam_service.modality;

public class ModalityNotFoundException extends RuntimeException {

    public ModalityNotFoundException(Long id) {
        super("Modality not found with id " + id);
    }
}
