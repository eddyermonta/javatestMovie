package com.platzi.javatest.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    private final List<Double> prices = new ArrayList<>();
    private double discount = 0;

    public double getTotal() {
        double result = prices.stream().
                mapToDouble(Double::doubleValue)
                .sum();
        return result * (1 - (discount / 100.0));
    }

    public void addPrices(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
