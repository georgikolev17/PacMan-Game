package Common;

import java.util.Objects;

/**
 * Summary: Class coordinates stores coordinates (row and column) of given location in the map.
 */
public class Coordinates {
    private int row;
    
    public int getRow() {
        return row;
    }

    private int col;

    public int getCol() {
        return col;
    }

    /**
     * Initializes new object of type Coordinates.
     * @param row row-coordinate.
     * @param col column-coordinate.
     */
    public Coordinates(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }

    // Override equals() to compare based on name and age
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) { 
            return false;
        }

        Coordinates coordinates = (Coordinates) o;
        return this.row == coordinates.row && this.col == coordinates.col;
    }

    // Override hashCode() to generate hash based on name and age
    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
