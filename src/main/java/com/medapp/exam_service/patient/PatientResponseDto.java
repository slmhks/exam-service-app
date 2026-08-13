package com.medapp.exam_service.patient;

import java.time.LocalDate;

/**
 * DTO to send reply back to the HTTP request
 */
public class PatientResponseDto {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String mrn;
    private final LocalDate dateOfBirth;

    private PatientResponseDto(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.mrn = builder.mrn;
        this.dateOfBirth = builder.dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMrn() {
        return mrn;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Long id;
        private String firstName;
        private String lastName;
        private String mrn;
        private LocalDate dateOfBirth;

        public PatientResponseDto build() {
            return new PatientResponseDto(this);
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder mrn(String mrn) {
            this.mrn = mrn;
            return this;
        }

        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }
    }

}
