/**
 * The gameboard class creates a 2D integer array to represent the gameboard.
 * 0 means the space is empty
 * 1 means the space is filled
 * 2 means the space if off-limits
 */
public class Gameboard {
    private int[][] gameboard;

    public Gameboard(int length, int width) {
        gameboard = new int[length][width];
    }

    public void nullifySpace(int xCoord, int yCoord) {
        // Make sure the space exists
        if (!(xCoord > gameboard.length || yCoord > gameboard[0].length || xCoord < 0 || yCoord < 0)) {
            gameboard[xCoord][yCoord] = 2;
        }
    }

    public void addPeg(int xCoord, int yCoord) {
        // Make sure the space exists and is part of the board
        if (!(xCoord > gameboard.length || yCoord > gameboard[0].length || xCoord < 0 || yCoord < 0
            || gameboard[xCoord][yCoord] != 2)) {

            gameboard[xCoord][yCoord] = 1;
        }
    }

    public void removePeg(int xCoord, int yCoord) {
        // Make sure the space exists and is part of the board
        if (!(xCoord > gameboard.length || yCoord > gameboard[0].length || xCoord < 0 || yCoord < 0
                || gameboard[xCoord][yCoord] != 2)) {

            gameboard[xCoord][yCoord] = 0;
        }
    }
}
