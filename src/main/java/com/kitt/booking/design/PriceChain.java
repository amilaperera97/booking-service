package com.kitt.booking.design;

import org.springframework.stereotype.Component;

@Component
public class PriceChain {

    public Handler handler;

    public PriceChain() {
        this.handler = new PricePerWeek();
        Handler priceDayHandler = new PricePerDay();
        Handler priceHourHandler = new PricePerHour();
        Handler priceMinutesHandler = new PricePerMinute();

        handler.setSuccessor(priceDayHandler);
        priceDayHandler.setSuccessor(priceHourHandler);
        priceHourHandler.setSuccessor(priceMinutesHandler);
    }
}
