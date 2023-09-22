package com.platzi.javatest.discounts;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PriceCalculatorTest {
    PriceCalculator calculator;

    @Before
    public void setup() {
        calculator = new PriceCalculator();
    }

    @Test
    public void total_zero_when_there_are_prices() {
        assertThat(calculator.getTotal(), is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices() {
        calculator.addPrices(10.2);
        calculator.addPrices(15.5);
        assertThat(calculator.getTotal(), is(25.7));
    }

    @Test
    public void total_with_discount() {
        calculator.addPrices(12.5);
        calculator.addPrices(17.5);

        calculator.setDiscount(25);
        assertThat(calculator.getTotal(), is(22.5));
    }
}