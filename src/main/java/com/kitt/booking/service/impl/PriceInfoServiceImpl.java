package com.kitt.booking.service.impl;

import com.kitt.booking.dto.RoomBookingRequestDto;
import com.kitt.booking.design.PriceChain;
import com.kitt.booking.exception.InvalidInputException;
import com.kitt.booking.service.PriceInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceInfoServiceImpl implements PriceInfoService {

    private final PriceChain priceChain;

    @Override
    public int getPrice(int noOfMinutes) throws InvalidInputException {
        if (noOfMinutes <= 0)
            throw new InvalidInputException("Invalid input : " + noOfMinutes);

        RoomBookingRequestDto roomBookingRequest = roomBookingRequestInfoCalculation(noOfMinutes);

        return priceChain.handler
                .applyPrice(roomBookingRequest);
    }

    /**
     * The method does the background calculation.
     *
     * @param noOfMinutes
     * @return
     */
    private RoomBookingRequestDto roomBookingRequestInfoCalculation(int noOfMinutes) {

        int noOfWeeks = ((noOfMinutes / 60) / 24) / 7;
        int noOfDays = ((noOfMinutes / 60) / 24) % 7;

        int consumedMinutes = (((noOfWeeks * 7) + noOfDays) * 24) * 60;
        int noOfHours = (noOfMinutes - consumedMinutes) / 60;
        int remainingMinutes = (noOfMinutes - consumedMinutes) % 60;

        if (remainingMinutes > 11) {
            noOfHours += 1;
        }
        if (noOfHours > 2) {
            noOfDays += 1;
        }
        if (noOfDays > 1) {
            noOfWeeks += 1;
        }

        return RoomBookingRequestDto.builder()
                .noOfWeeks(noOfWeeks)
                .noOfDays(noOfDays)
                .noOfHours(noOfHours)
                .noOfMinutes(remainingMinutes)
                .build();
    }
}
