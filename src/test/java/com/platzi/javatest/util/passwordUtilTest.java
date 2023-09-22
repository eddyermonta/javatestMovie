package com.platzi.javatest.util;


import org.junit.Test;

import static com.platzi.javatest.util.passwordUtil.SecurityLevel.*;
import static org.junit.Assert.assertEquals;

public class passwordUtilTest {
    @Test
    public void weakLess8Letters() {
        assertEquals(WEAK, passwordUtil.assessPassword("1234567"));
    }

    @Test
    public void weakOnlyLetters() {
        assertEquals(WEAK, passwordUtil.assessPassword("abcdefgh"));
    }

    @Test
    public void mediumLettersNumbers() {
        assertEquals(MEDIUM, passwordUtil.assessPassword("adcd1234"));
    }

    @Test
    public void StrongLettersNumbersSymbols() {
        assertEquals(STRONG, passwordUtil.assessPassword("adcd1234#"));
    }
}