package com.medapp.exam_service.modality;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/modalities")
public class ModalityController {

    private final ModalityService modalityService;

    public ModalityController(ModalityService modalityService) {
        this.modalityService = modalityService;
    }

    @PostMapping
    public ResponseEntity<ModalityResponseDto> createModality(@Valid @RequestBody CreateModalityRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.modalityService.createModality(request));
    }

    @GetMapping
    public ResponseEntity<List<ModalityResponseDto>> getAllModalities() {
        return ResponseEntity.ok(this.modalityService.getAllModalities());
    }
}
