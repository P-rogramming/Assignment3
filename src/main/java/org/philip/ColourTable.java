package org.philip;

import java.util.Arrays;

public class ColourTable {
    private int[][] table;
    private int paletteSize;
    private int numAdded;


    /**
     * The ColourTable function takes in a palette size and creates a ColourTable object.
     *
     * @param paletteSize Determine the size of the colour table
     *
     */
    public ColourTable(int paletteSize) {

        if(paletteSize <= 1 || paletteSize > 1025 || ((paletteSize & (paletteSize - 1)) != 0)){
            throw new IllegalArgumentException("Invalid palette size specified");
        }
        this.paletteSize = paletteSize;
        this.table = new int[paletteSize][3];
        this.numAdded = 0;

    }

    /**
     * The add function adds a new colour to the ColourTable.
     *
     * @param rgbColour Add a new colour to the table
     *
     */
    public void add(int[] rgbColour) {
        if (rgbColour.length != 3) {
            throw new IllegalArgumentException("Invalid RGB color specified: must have exactly 3 elements");
        }
        for (int value : rgbColour) {
            if (value < 0 || value > 255) {
                throw new IllegalArgumentException("Invalid RGB color specified: values must be between 0 and 255");
            }
        }


        if (Arrays.stream(table).anyMatch(color -> Arrays.equals(color, rgbColour))) {
            throw new IllegalArgumentException("Colour already exists in the ColourTable");
        }

        if (this.numAdded >= this.paletteSize) {
            throw new IllegalStateException("ColourTable is full");
        } else {
            this.table[numAdded] = rgbColour;
            this.numAdded++;
        }
    }

    /**
     * The getTable function returns the table of the board.
     *
     * @return The table variable, which is a 2d array of integers
     */
    public int[][] getTable() {
        return this.table;
    }

}
