package com.medapp.exam_service.patient;

public class PatientMapper {

    public static Patient toEntity(CreatePatientRequestDto createPatientRequestDto) {
        Patient patient = new Patient();
        patient.setMrn(createPatientRequestDto.getMrn());
        patient.setFirstName(createPatientRequestDto.getFirstName());
        patient.setLastName(createPatientRequestDto.getLastName());
        patient.setDateOfBirth(createPatientRequestDto.getDateOfBirth());
        return patient;
    }

    public static PatientResponseDto toResponse(Patient patient) {
        return PatientResponseDto.builder()
                .id(patient.getId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .mrn(patient.getMrn())
                .dateOfBirth(patient.getDateOfBirth())
                .build();
    }
}
