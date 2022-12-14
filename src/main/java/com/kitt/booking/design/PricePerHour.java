package com.kitt.booking.design;

import com.kitt.booking.dto.RoomBookingRequestDto;

import static com.kitt.booking.util.constant.PriceConstance.PRICE_PER_HOUR;

public class PricePerHour extends Handler {
    @Override
    public int applyPrice(RoomBookingRequestDto roomBookingRequestDto) {
        if (roomBookingRequestDto.getNoOfHours() >= 1) {
            return roomBookingRequestDto.getNoOfHours() * PRICE_PER_HOUR;
        } else {
            return successor.applyPrice(roomBookingRequestDto);
        }
    }
}
