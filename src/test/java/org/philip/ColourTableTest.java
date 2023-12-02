package org.philip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColourTableTest {

    /**
     * The testConstructorWithInvalidPaletteSize function tests the ColourTable constructor with an invalid palette size.
     * The test passes if the constructor throws an IllegalArgumentException when passed a palette size of 5.
     *
     */
    @Test
    void testConstructorWithInvalidPaletteSize() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(5));
    }



    /**
     * The testAdd24BitRGBColour function tests the add function with a 24 bit RGB colour.
     * The test passes if the method adds the colour to the ColourTable .
     *
     */
    @Test
    void testAdd24BitRGBColour() {
        ColourTable testTable = new ColourTable(4);
        int[] colour = {200, 100, 10};
        testTable.add(colour);
        int[][] expectedTable = {{200, 100, 10}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertArrayEquals(expectedTable, testTable.getTable());
    }

    /**
     * The testAddInvalid24BitRGBColour function tests the add function with an invalid 24 bit RGB colour.
     * The test passes if the method throws an IllegalArgumentException when passed a colour size of 4 .
     *
     */
    @Test
    void testAddInvalid24BitRGBColour() {
        ColourTable testTable = new ColourTable(4);
        int[] colour = {200, 100, 10, 3};
        assertThrows(IllegalArgumentException.class, () -> testTable.add(colour));
    }




}