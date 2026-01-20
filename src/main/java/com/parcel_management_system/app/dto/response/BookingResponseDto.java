package com.parcel_management_system.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDto {
    private String bookingId; // This corresponds to trakingId in backend
    private Long id; // Primary key if needed
}
