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


}