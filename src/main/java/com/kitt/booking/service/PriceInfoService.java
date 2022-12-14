package com.kitt.booking.service;

import com.kitt.booking.exception.InvalidInputException;

public interface PriceInfoService {

    int getPrice(int noOfMinutes) throws InvalidInputException;
}
