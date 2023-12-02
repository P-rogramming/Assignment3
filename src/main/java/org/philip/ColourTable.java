package org.philip;

public class ColourTable {

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

    }

}
