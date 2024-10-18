import Game.Game;
import Movement.GhostMovement;
import java.util.Scanner;

/**
 * Summary: asd.
 */
public class Main {

    public static void main(String[] args) {
        new Game().NewGame();

        // String gridString = "111111111111111111111111111111" // a string of the grid
        //                   + "100000000011000000000000000001"
        //                   + "101011111011111011111101101101"
        //                   + "100011100000000010000101100001"
        //                   + "101010101111111010110101110101"
        //                   + "101010000000011000000000000101"
        //                   + "101010111011000011111111011101"
        //                   + "100000111000022011111111010001"
        //                   + "110110001011022000000011010111"
        //                   + "110111100011000011101011000111"
        //                   + "110000101011101000001011010111"
        //                   + "111110101011101011111011010111"
        //                   + "100000001000001000111011010001"
        //                   + "101011111110001101110011011101"
        //                   + "101010000000111101100111011101"
        //                   + "101010110110111101001111011101"
        //                   + "100000110110000000011100011101"
        //                   + "101010010111111111000001000001"
        //                   + "100011000111111111110111011111" 
        //                   + "111111111111111111111111111111";
        
        // int i = 0; // To go through the String "gridString".
        // int j = 0; // To go through every cell in each row.
        // var grid = new int[20][30];
        // for (int[] row : grid) {
        //     j = 0;
        //     for (int cell : row) {
        //         String cellChar = gridString.substring(i, i + 1); // Cell as string.
        //         cell = Integer.parseInt(cellChar); // Sets cell to cellChar converted as an int.
        //         row[j] = cell;
        //         i++;
        //         j++;
        //     }
        // }

        // var movement = new GhostMovement(grid);
        // Scanner scanner = new Scanner(System.in);
        // while (true) {
        //     int gx = scanner.nextInt(); 
        //     int gy = scanner.nextInt(); 
        //     var coordinates = movement.smartStep(gx, gy, 1, 9);
        //     System.out.println(coordinates.getRow() + " " + coordinates.getCol());
        // }
    }
}