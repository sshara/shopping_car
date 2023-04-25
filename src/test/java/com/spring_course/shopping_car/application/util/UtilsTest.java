package com.spring_course.shopping_car.application.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void converFromDollarToCop() {
    }

    @Test
    void sumaTestWhenIsOK() {

        // Given
        Utils utils = new Utils();
        int num1 = 5;
        int num2 = 4;

        // When
        int result = utils.suma(num1, num2);

        // Then
        assertEquals(9, result);

    }

    @Test
    void sumaTestWhenIsError() {
    }
}