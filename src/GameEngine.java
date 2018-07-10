public class GameEngine {
    private static final int LENGTH = 7;
    private static final int WIDTH = 7;
    private static final int xCenter = 3;
    private static final int yCenter = 3;

    private static Gameboard gameboard;

    private static void setUpGame() {
        gameboard = new Gameboard(LENGTH, WIDTH);
        nullifySpaces(gameboard);

        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                gameboard.addPeg(i, j);
            }
        }

        gameboard.removePeg(xCenter, yCenter);
    }

    private static void nullifySpaces(Gameboard gameboard) {
        // Magic Numbers Galore!!!!
        gameboard.nullifySpace(0,0);
        gameboard.nullifySpace(0,1);
        gameboard.nullifySpace(1, 0);
        gameboard.nullifySpace(1, 1);

        gameboard.nullifySpace(0,5);
        gameboard.nullifySpace(0, 6);
        gameboard.nullifySpace(1, 5);
        gameboard.nullifySpace(1, 6);

        gameboard.nullifySpace(5, 0);
        gameboard.nullifySpace(5, 1);
        gameboard.nullifySpace(6, 0);
        gameboard.nullifySpace(6, 1);

        gameboard.nullifySpace(5, 5);
        gameboard.nullifySpace(5, 6);
        gameboard.nullifySpace(6, 5);
        gameboard.nullifySpace(6, 6);
    }

    public static void runGame() {
    }
}
