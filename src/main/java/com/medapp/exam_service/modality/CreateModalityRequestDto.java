package com.medapp.exam_service.modality;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateModalityRequestDto {

    @NotNull(message = "Modality type is required")
    private ModalityType type;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Room number is required")
    private String roomNumber;
}