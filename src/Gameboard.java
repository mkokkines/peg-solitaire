/**
 * The gameboard class creates a 2D integer array to represent the gameboard.
 * 0 means the space is empty
 * 1 means the space is filled
 * 2 means the space if off-limits
 */
public class Gameboard {
    private char[][] gameboard;

    public Gameboard(int length, int width) {
        gameboard = new char[length][width];
    }

    public void nullifySpace(int xCoord, int yCoord) {
        // Make sure the space exists
        if (!(xCoord > gameboard.length || yCoord > gameboard[0].length || xCoord < 0 || yCoord < 0)) {
            gameboard[xCoord][yCoord] = '\u2001';
        }
    }

    public void addPeg(int xCoord, int yCoord) {
        // Make sure the space exists and is part of the board
        if (!(xCoord > gameboard.length || yCoord > gameboard[0].length || xCoord < 0 || yCoord < 0
            || gameboard[xCoord][yCoord] == '\u2001')) {

            gameboard[xCoord][yCoord] = '\u25cf';
        }
    }

    public void removePeg(int xCoord, int yCoord) {
        // Make sure the space exists and is part of the board
        if (!(xCoord > gameboard.length || yCoord > gameboard[0].length || xCoord < 0 || yCoord < 0
                || gameboard[xCoord][yCoord] == '\u2001')) {

            gameboard[xCoord][yCoord] = '\u25a1';
        }
    }

    public void printGameboard() {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[0].length; j++) {
                System.out.print(gameboard[i][j]);
            }

            System.out.println();
        }
    }
}
