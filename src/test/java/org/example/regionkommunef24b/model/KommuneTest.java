package org.example.regionkommunef24b.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KommuneTest {

    @Test
    void test() {
        if (3>4)
        fail("Not yet implemented");
    }

    @Test
    void test2() {
        assertEquals("ABC", "ABC");
    }

    @Test
    void testDiv0() {
        int i = 0;
        int y = 100;
        assertEquals(0,y/i);
    }

    @Test
    void testArr() {
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,4,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    void testArrFejl() {
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,14,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    void testArrFejlMsg() {
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,14,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers, () -> "sort fail af 4 tal" + expected[1]);
    }


}