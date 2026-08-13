package com.medapp.exam_service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientResponseDto createPatient(CreatePatientRequestDto createPatientRequestDto) {
        Patient patient = PatientMapper.toEntity(createPatientRequestDto);
        Patient saved = patientRepository.save(patient);
        return PatientMapper.toResponse(saved);
    }
}
