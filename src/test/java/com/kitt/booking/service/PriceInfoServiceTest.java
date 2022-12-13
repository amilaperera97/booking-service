package com.kitt.booking.service;

import com.kitt.booking.service.impl.PriceInfoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PriceInfoServiceTest {

    private PriceInfoService priceInfoService;

    @BeforeEach
    void setup() {
        priceInfoService = new PriceInfoServiceImpl();
    }

    @ParameterizedTest
    @CsvSource({"1440,60", "2880,105", "20160,210"})
    void checkPriceInfoSuccess(int noOfMinutes, int expectedPrice) {
        int price = priceInfoService.getPrice(noOfMinutes);
        assertThat(price).isEqualTo(expectedPrice);
    }
}
