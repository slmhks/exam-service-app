package com.medapp.exam_service.modality;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModalityResponseDto {

    private Long id;
    private ModalityType type;
    private String name;
    private String roomNumber;
    private boolean available;
}