package com.platzi.javatest.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FizzBuzzTest {
    @Test
    public void return_fizz_when_number_is_divisible_by_3() {
        assertThat(FizzBuzz.fizzBuzz(3), is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(6), is("Fizz"));
    }

    @Test
    public void return_buzz_when_number_is_divisible_by_5() {
        assertThat(FizzBuzz.fizzBuzz(5), is("Buzz"));
        assertThat(FizzBuzz.fizzBuzz(10), is("Buzz"));
    }

    @Test
    public void return_FizzBuzz_when_number_is_divisible_by_3_and_5() {
        assertThat(FizzBuzz.fizzBuzz(15), is("FizzBuzz"));
        assertThat(FizzBuzz.fizzBuzz(30), is("FizzBuzz"));
    }

    @Test
    public void for_others_return_number() {
        assertThat(FizzBuzz.fizzBuzz(2), is("2"));
        assertThat(FizzBuzz.fizzBuzz(16), is("16"));
    }

    @Test
    public void when_number_low() {
        FizzBuzz.fizzBuzz(-5);
    }
}