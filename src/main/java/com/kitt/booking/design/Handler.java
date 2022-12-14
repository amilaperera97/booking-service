package com.kitt.booking.design;

import com.kitt.booking.dto.RoomBookingRequestDto;

public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract int applyPrice(RoomBookingRequestDto roomBookingRequestDto);
}
