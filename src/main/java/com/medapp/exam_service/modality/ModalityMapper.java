package com.medapp.exam_service.modality;

public class ModalityMapper {

    public static Modality toEntity(CreateModalityRequestDto request) {
        Modality modality = new Modality();
        modality.setType(request.getType());
        modality.setName(request.getName());
        modality.setRoomNumber(request.getRoomNumber());
        modality.setAvailable(true); // new modalities always start available
        return modality;
    }

    public static ModalityResponseDto toResponse(Modality modality) {
        return ModalityResponseDto.builder()
                .id(modality.getId())
                .type(modality.getType())
                .name(modality.getName())
                .roomNumber(modality.getRoomNumber())
                .available(modality.isAvailable())
                .build();
    }
}