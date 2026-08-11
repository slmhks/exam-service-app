package com.medapp.exam_service;

import com.medapp.exam_service.exam.Exam;
import com.medapp.exam_service.exam.ExamRepository;
import com.medapp.exam_service.exam.ExamStatus;
import com.medapp.exam_service.modality.Modality;
import com.medapp.exam_service.modality.ModalityRepository;
import com.medapp.exam_service.modality.ModalityType;
import com.medapp.exam_service.patient.Patient;
import com.medapp.exam_service.patient.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class SanityIT {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModalityRepository modalityRepository;

    @Autowired
    private ExamRepository examRepository;

    @Test
    void savesAndRetrievesExamWithRelationships() {

        String _PATIENT_MRN_ = "MRN-0001";

        // Create a patient
        Patient patient = new Patient();
        patient.setFirstName("Roberto");
        patient.setLastName("Plant");
        patient.setMrn(_PATIENT_MRN_);
        patient.setDateOfBirth(LocalDate.of(1990, 10, 30));
        patientRepository.save(patient);

        // Create a modality
        Modality modality = new Modality();
        modality.setName("XRAY Siemens");
        modality.setRoomNumber("Room 101");
        modality.setType(ModalityType.CT);
        modality.setAvailable(true);
        modalityRepository.save(modality);

        // Create an exam
        Exam exam = new Exam();
        exam.setPatient(patient);
        exam.setModality(modality);
        exam.setStatus(ExamStatus.ARRIVED);
        exam.setExamType("CT_HEAD");
        examRepository.save(exam);

        // Assert: Patient MRN
        Optional<Patient> foundPatient = patientRepository.findByMrn(_PATIENT_MRN_);
        assertThat(foundPatient).isPresent();
        assertThat(foundPatient.get().getLastName()).isEqualTo("Plant");

        // Assert: Find by status
        List<Exam> arrivedExams = examRepository.findByStatus(ExamStatus.ARRIVED);
        assertThat(arrivedExams).hasSize(1);
        assertThat(arrivedExams.getFirst().getExamType()).isEqualTo("CT_HEAD");

        // Assert: Find by patient ID
        List<Exam> examsForPatient = examRepository.findByPatientId(patient.getId());
        assertThat(examsForPatient).hasSize(1);

        // Assert: Find by type and available equals true
        List<Modality> modalitiesAvailable = modalityRepository.findByTypeAndAvailableTrue(ModalityType.CT);
        assertThat(modalitiesAvailable).hasSize(1);

    }
}
