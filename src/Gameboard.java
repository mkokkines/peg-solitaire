import java.util.ArrayList;

/**
 * The gameboard class creates a 2D character array to represent the gameboard.
 * □ means the space is empty
 * \u25cf means the space is filled
 * \u2001 means the space if off-limits
 */
public class Gameboard {
    private char[][] gameboard;

    public Gameboard(int length, int width) {
        gameboard = new char[length][width];
    }

    public char getSpace(int xCoord, int yCoord) {
        return gameboard[xCoord][yCoord];
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

    public ArrayList<Coordinate> getBlankSpaces() {
        ArrayList<Coordinate> blankSpaces = new ArrayList<Coordinate>();

        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[0].length; j++) {
                if (gameboard[i][j] == '\u25a1') {
                    blankSpaces.add(new Coordinate(i, j));
                }
            }
        }

        return blankSpaces;
    }
}
