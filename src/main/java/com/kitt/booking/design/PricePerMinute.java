package com.kitt.booking.design;

import com.kitt.booking.dto.RoomBookingRequestDto;

import static com.kitt.booking.util.constant.PriceConstance.PRICE_PER_MINUTE;

public class PricePerMinute extends Handler {
    @Override
    public int applyPrice(RoomBookingRequestDto roomBookingRequestDto) {
        if (roomBookingRequestDto.getNoOfMinutes() >= 1) {
            return roomBookingRequestDto.getNoOfMinutes() * PRICE_PER_MINUTE;
        } else {
            return successor.applyPrice(roomBookingRequestDto);
        }
    }
}
