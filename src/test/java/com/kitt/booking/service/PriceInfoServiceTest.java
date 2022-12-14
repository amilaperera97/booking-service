package com.kitt.booking.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PriceInfoServiceTest {

    @Autowired
    private PriceInfoService priceInfoService;


    @ParameterizedTest
    @CsvSource({"1440,60", "2880,105", "20160,210", "15650,210", "10,20","2880,105"})
    void checkPriceInfoSuccess(int noOfMinutes, int expectedPrice) {
        int price = priceInfoService.getPrice(noOfMinutes);
        assertThat(price).isEqualTo(expectedPrice);
    }
}
