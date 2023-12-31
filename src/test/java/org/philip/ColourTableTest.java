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
     * The testConstructor function tests the ColourTable constructor with a valid palette size.
     * The test passes if the constructor creates an empty int array.
     *
     */
    @Test
    void testConstructorWithValidPaletteSize() {
        ColourTable testTable = new ColourTable(4);
        int[][] expectedTable = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertArrayEquals(expectedTable, testTable.getTable());
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
     * The testAddInvalidRGBColourWithLessThanThreeElements function tests the add function of the ColourTable class.
     * It checks that an IllegalArgumentException is thrown when a colour with less than three elements is added to the table.
     *
     */
    @Test
    void testAddInvalidRGBColourWithLessThanThreeElements() {
        ColourTable testTable = new ColourTable(4);
        int[] colour = {200, 100};
        assertThrows(IllegalArgumentException.class, () -> testTable.add(colour));
    }

    /**
     * The testAddInvalidRGBColourWithMoreThanThreeElements function tests the add function of the ColourTable class.
     * It checks that an IllegalArgumentException is thrown when a colour with more than three elements is added to the table.
     *
     */
    @Test
    void testAddInvalidRGBColourWithMoreThanThreeElements() {
        ColourTable testTable = new ColourTable(4);
        int[] colour = {200, 100, 10, 3};
        assertThrows(IllegalArgumentException.class, () -> testTable.add(colour));
    }

    /**
     * The testAddInvalidRGBColourWithNegativeValues function tests the add function of the ColourTable class.
     * It creates a new ColourTable object with 4 buckets, and then attempts to add an RGB colour array with negative values.
     * This should throw an IllegalArgumentException, which is caught by assertThrows().
     *
     */
    @Test
    void testAddInvalidRGBColourWithNegativeValues() {
        ColourTable testTable = new ColourTable(4);
        int[] colour = {200, -100, 10};
        assertThrows(IllegalArgumentException.class, () -> testTable.add(colour));
    }

    /**
     * The testAddInvalidRGBColourWithOutOfRangeValues function tests the add function of the ColourTable class.
     * It checks that an IllegalArgumentException is thrown when a colour with out-of-range values is added to the table.
     *
     *
     */
    @Test
    void testAddInvalidRGBColourWithOutOfRangeValues() {
        ColourTable testTable = new ColourTable(4);
        int[] colour = {300, 100, 10};
        assertThrows(IllegalArgumentException.class, () -> testTable.add(colour));
    }

    /**
     * The testAddDuplicateRGBColour function tests the add function of the ColourTable class.
     * It checks that an IllegalArgumentException is thrown when a duplicate colour is added to the table.
     *
     *
     */
    @Test
    void testAddDuplicateRGBColour() {
        ColourTable testTable = new ColourTable(4);
        int[] colour = {200, 100, 10};
        testTable.add(colour);
        assertThrows(IllegalArgumentException.class, () -> testTable.add(colour));
    }

    /**
     * The testShowTableWithEmptyTable function tests the showTable function of the ColourTable class.
     * It creates a new ColourTable object with 16 colours and then checks that it prints out an empty table.
     *
     *
     */
    @Test
    public void testShowTableWithEmptyTable() {
        ColourTable colourTable = new ColourTable(16);

        String expectedOutput = "Colour Table:\n";
        assertEquals(expectedOutput, colourTable.showTable());
    }

    /**
     * The testShowTableWithNonEmptyTable function tests the showTable function of the ColourTable class.
     * It creates a new colour table with 16 slots, and adds 3 colours to it.
     * Then it checks that when we call showTable on this colour table, we get back a string containing all three colours in order.
     *
     *
     */
    @Test
    public void testShowTableWithNonEmptyTable() {
        ColourTable colourTable = new ColourTable(16);
        colourTable.add(new int[]{255, 0, 0});
        colourTable.add(new int[]{0, 255, 0});
        colourTable.add(new int[]{0, 0, 255});

        String expectedOutput = """
                Colour Table:
                RGB: 255, 0, 0
                RGB: 0, 255, 0
                RGB: 0, 0, 255
                """;
        assertEquals(expectedOutput, colourTable.showTable());
    }






}