package com.kitt.booking.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceInfoResponseDto {
    private int minutesRequested;
    private int price;
}
