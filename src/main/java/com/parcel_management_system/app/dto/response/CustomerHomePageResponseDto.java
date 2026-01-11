package com.parcel_management_system.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerHomePageResponseDto {
    private Long id;
    private String name;
    private Integer totalBookings;
    private Integer ongoingBookings;
    private Integer completedBookings;
    private Integer cancelledBookings;
}
