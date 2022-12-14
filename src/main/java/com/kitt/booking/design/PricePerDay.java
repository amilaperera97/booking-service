package com.kitt.booking.design;

import com.kitt.booking.dto.RoomBookingRequestDto;

import static com.kitt.booking.util.constant.PriceConstance.PRICE_PER_DAY;

public class PricePerDay extends Handler {
    @Override
    public int applyPrice(RoomBookingRequestDto roomBookingRequestDto) {
        if (roomBookingRequestDto.getNoOfDays() >= 1) {
            return roomBookingRequestDto.getNoOfDays() * PRICE_PER_DAY;
        } else {
            return successor.applyPrice(roomBookingRequestDto);
        }
    }
}
