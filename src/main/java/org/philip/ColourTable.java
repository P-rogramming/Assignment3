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

        validatePaletteSize(paletteSize);
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
        validateRgbColour(rgbColour);
        checkDuplicateColour(rgbColour);

        checkTableNotFull();
        this.table[numAdded] = rgbColour;
        this.numAdded++;
    }



    /**
     * The validatePaletteSize function checks to see if the palette size is valid.
     * If it is not, then an IllegalArgumentException will be thrown.
     *
     * @param paletteSize Determine the size of the palette
     *
     */
    private void validatePaletteSize(int paletteSize) {
        if (paletteSize <= 1 || paletteSize > 1025 || ((paletteSize & (paletteSize - 1)) != 0)) {
            throw new IllegalArgumentException("Invalid palette size specified");
        }
    }


    /**
     * The validateRgbColour function checks that the RGB colour array has exactly 3 elements, and that each element is between 0 and 255.
     *
     * @param rgbColour Pass the rgb colour values to the function
     *
     */
    private void validateRgbColour(int[] rgbColour) {
        if (rgbColour.length != 3) {
            throw new IllegalArgumentException("Invalid RGB colour specified: must have exactly 3 elements");
        }
        for (int value : rgbColour) {
            if (value < 0 || value > 255) {
                throw new IllegalArgumentException("Invalid RGB colour specified: values must be between 0 and 255");
            }
        }
    }

    /**
     * The checkDuplicateColour function checks if the colour already exists in the ColourTable.
     * If it does, an IllegalArgumentException is thrown.
     * @param rgbColour Check if the colour already exists in the table
     *
     */
    private void checkDuplicateColour(int[] rgbColour) {
        if (Arrays.stream(table).anyMatch(colour -> Arrays.equals(colour, rgbColour))) {
            throw new IllegalArgumentException("Colour already exists in the ColourTable");
        }
    }


     /**
      * The checkTableNotFull function checks to see if the table is full.
      * If it is, then an IllegalStateException will be thrown.
      *
      */
     private void checkTableNotFull() {
        if (this.numAdded >= this.table.length) {
            throw new IllegalStateException("ColourTable is full");
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

    /**
     * The showTable function displays the current contents of the ColourTable.
     */
    public String showTable() {
        StringBuilder output = new StringBuilder();
        output.append("Colour Table:\n");
        for (int i = 0; i < numAdded; i++) {
            int[] colour = table[i];
            output.append("RGB: ").append(colour[0]).append(", ").append(colour[1]).append(", ").append(colour[2]).append("\n");
        }
        return output.toString();
    }
}
