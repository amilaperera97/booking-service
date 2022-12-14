package com.kitt.booking.design;

import com.kitt.booking.dto.RoomBookingRequestDto;

import static com.kitt.booking.util.constant.PriceConstance.PRICE_PER_WEEK;

public class PricePerWeek extends Handler {
    @Override
    public int applyPrice(RoomBookingRequestDto roomBookingRequestDto) {
        if (roomBookingRequestDto.getNoOfWeeks() >= 1) {
            return roomBookingRequestDto.getNoOfWeeks() * PRICE_PER_WEEK;
        } else {
            return successor.applyPrice(roomBookingRequestDto);
        }
    }
}
