package com.medapp.exam_service.modality;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "modalities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModalityType type; // CT, MRI, XRAY

    @Column(nullable = false)
    private String name; // e.g. "CT Scanner Room 3"

    @Column(nullable = false)
    private String roomNumber;

    @Column(nullable = false)
    private boolean available = true;
}