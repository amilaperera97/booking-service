package com.kitt.booking.rest;

import com.kitt.booking.dto.PriceInfoResponseDto;
import com.kitt.booking.dto.ResponseDto;
import com.kitt.booking.exception.InvalidInputException;
import com.kitt.booking.service.PriceInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.kitt.booking.util.constant.ControllerConstance.API_V1;
import static com.kitt.booking.util.constant.ControllerConstance.GET_PRICE_BY_MINUTES;

@RestController
@RequestMapping(value = API_V1)
@RequiredArgsConstructor
public class PriceInfoController {

    private final PriceInfoService priceInfoService;

    @GetMapping(value = GET_PRICE_BY_MINUTES + "/{minutes}")
    public ResponseDto<PriceInfoResponseDto> getPriceByMinutes(@PathVariable("minutes") int noOfMinutes) {
        try {
            int price = priceInfoService.getPrice(noOfMinutes);
            return new ResponseDto<PriceInfoResponseDto>().buildSuccessMsgWithData(
                    PriceInfoResponseDto.builder()
                            .minutesRequested(noOfMinutes)
                            .price(price)
                            .build());
        } catch (InvalidInputException iie) {
            return new ResponseDto<PriceInfoResponseDto>().buildFailureMsg(iie);
        }
    }

}
