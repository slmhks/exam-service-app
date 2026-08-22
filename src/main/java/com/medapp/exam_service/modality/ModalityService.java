package com.medapp.exam_service.modality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModalityService {

    private final ModalityRepository modalityRepository;

    @Autowired
    public ModalityService(ModalityRepository modalityRepository) {
        this.modalityRepository = modalityRepository;
    }

    public ModalityResponseDto createModality(CreateModalityRequestDto request) {
        Modality modality = ModalityMapper.toEntity(request);
        Modality saved = modalityRepository.save(modality);
        return ModalityMapper.toResponse(saved);
    }

    public List<ModalityResponseDto> getAllModalities() {
        return modalityRepository.findAll().stream().map(ModalityMapper::toResponse).toList();
    }
}
