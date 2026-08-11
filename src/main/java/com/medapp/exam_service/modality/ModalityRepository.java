package com.medapp.exam_service.modality;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ModalityRepository extends JpaRepository<Modality,Long> {

    List<Modality> findByTypeAndAvailableTrue(ModalityType type);
}
