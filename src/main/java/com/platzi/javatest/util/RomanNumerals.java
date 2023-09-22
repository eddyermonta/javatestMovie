package com.platzi.javatest.util;

public class RomanNumerals {
    public enum RomanNumeral {
        M(1000, "M"),
        CM(900, "CM"),
        D(500, "D"),
        CD(400, "CD"),
        C(100, "C"),
        XC(90, "XC"),
        L(50, "L"),
        XL(40, "XL"),
        X(10, "X"),
        IX(9, "IX"),
        V(5, "V"),
        IV(4, "IV"),
        I(1, "I");

        private final int arabicValue;
        private final String romanSymbol;

        RomanNumeral(int arabicValue, String romanSymbol) {
            this.arabicValue = arabicValue;
            this.romanSymbol = romanSymbol;
        }

        public int getArabicValue() {
            return arabicValue;
        }

        public String getRomanSymbol() {
            return romanSymbol;
        }
    }

    public static String arabicToRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Número fuera del rango válido (1-3999)");
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (RomanNumeral numeral : RomanNumeral.values()) {
            while (number >= numeral.getArabicValue()) {
                number -= numeral.getArabicValue();
                stringBuilder.append(numeral.getRomanSymbol());
            }
        }

        return stringBuilder.toString();
    }
}
