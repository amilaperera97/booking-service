package com.kitt.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class RoomBookingRequestDto {
    private int noOfMinutes;
    private int noOfHours;
    private int noOfDays;
    private int noOfWeeks;
}
