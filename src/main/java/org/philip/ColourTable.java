package org.philip;

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

    public void add(int[] rgbColour) {
        if (rgbColour.length != 3) {
            throw new IllegalArgumentException("Invalid RGB color specified: must have exactly 3 elements");
        }
        if (this.numAdded >= this.paletteSize) {
            throw new IllegalStateException("ColourTable is full");
        } else {
            this.table[numAdded] = rgbColour;
            this.numAdded++;
        }
    }

    public int[][] getTable() {
        return this.table;
    }

}
