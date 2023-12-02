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
     * The testAddInvalidRGBColorWithLessThanThreeElements function tests the add function of the ColourTable class.
     * It checks that an IllegalArgumentException is thrown when a colour with less than three elements is added to the table.
     *
     */
    @Test
    void testAddInvalidRGBColorWithLessThanThreeElements() {
        ColourTable testTable = new ColourTable(4);
        int[] colour = {200, 100};
        assertThrows(IllegalArgumentException.class, () -> testTable.add(colour));
    }

    /**
     * The testAddInvalidRGBColorWithMoreThanThreeElements function tests the add function of the ColourTable class.
     * It checks that an IllegalArgumentException is thrown when a colour with more than three elements is added to the table.
     *
     */
    @Test
    void testAddInvalidRGBColorWithMoreThanThreeElements() {
        ColourTable testTable = new ColourTable(4);
        int[] colour = {200, 100, 10, 3};
        assertThrows(IllegalArgumentException.class, () -> testTable.add(colour));
    }

    /**
     * The testAddInvalidRGBColorWithNegativeValues function tests the add function of the ColourTable class.
     * It creates a new ColourTable object with 4 buckets, and then attempts to add an RGB colour array with negative values.
     * This should throw an IllegalArgumentException, which is caught by assertThrows().
     *
     */
    @Test
    void testAddInvalidRGBColorWithNegativeValues() {
        ColourTable testTable = new ColourTable(4);
        int[] colour = {200, -100, 10};
        assertThrows(IllegalArgumentException.class, () -> testTable.add(colour));
    }

    /**
     * The testAddInvalidRGBColorWithOutOfRangeValues function tests the add function of the ColourTable class.
     * It checks that an IllegalArgumentException is thrown when a colour with out-of-range values is added to the table.
     *
     *
     */
    @Test
    void testAddInvalidRGBColorWithOutOfRangeValues() {
        ColourTable testTable = new ColourTable(4);
        int[] colour = {300, 100, 10};
        assertThrows(IllegalArgumentException.class, () -> testTable.add(colour));
    }













}