package Objects;

/**
 * Summary: The coin has a position on the map and points that it gives to the player.
 */
public class Coin {
    private int x;
    private int y;
    private int points;

    /**
     * Summary: Initializes a new Coin class with the given x and y coordinates and points.
     * @param x x-coordinate
     * @param y y-coordinate
     * @param points Points that the player receives when they collect the coin
     */
    public Coin(int x, int y, int points) {
        this.x = x;
        this.y = y;
        this.points = points;
    }

    /**
     * Summary: returns the x coordiante of the coin.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Summary: Sets the x coordiante of the coin.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Summary: returns the y coordiante of the coin.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Summary: sets the y coordiante of the coin.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Summary: returns the points that the player gets when collecting the coin.
     */
    public int getPoints() {
        return this.points;
    }
}
