import java.util.ArrayList;
import java.util.Stack;

public class GameEngine {
    private static final int LENGTH = 7;
    private static final int WIDTH = 7;
    private static final int XCENTER = 3;
    private static final int YCENTER = 3;

    private static Gameboard gameboard;
    private static Stack<Direction> directionList;
    private static Stack<Coordinate> coordinateList;

    private static void setUpGame() {
        directionList = new Stack<Direction>();
        coordinateList = new Stack<Coordinate>();
        gameboard = new Gameboard(LENGTH, WIDTH);

        nullifySpaces(gameboard);

        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                gameboard.addPeg(i, j);
            }
        }

        gameboard.removePeg(XCENTER, YCENTER);
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

    private static boolean verifyMove(Coordinate space, Direction direction) {
        return (direction == Direction.LEFT && space.xCoord > 1
                && (gameboard.getSpace(space.xCoord - 1, space.yCoord) == '\u25cf')
                && (gameboard.getSpace(space.xCoord - 2, space.yCoord) == '\u25cf'))
                || (direction == Direction.RIGHT && space.xCoord < 5
                && (gameboard.getSpace(space.xCoord + 1, space.yCoord) == '\u25cf')
                && (gameboard.getSpace(space.xCoord + 2, space.yCoord) == '\u25cf'))
                || (direction == Direction.DOWN && space.yCoord > 1
                && (gameboard.getSpace(space.xCoord, space.yCoord - 1) == '\u25cf')
                && (gameboard.getSpace(space.xCoord, space.yCoord - 2) == '\u25cf'))
                || (direction == Direction.UP && space.yCoord < 5
                && (gameboard.getSpace(space.xCoord, space.yCoord + 1) == '\u25cf')
                && (gameboard.getSpace(space.xCoord, space.yCoord + 2) == '\u25cf'));
    }

    private static void executeMove(Coordinate space, Direction direction) {
        gameboard.addPeg(space.xCoord, space.yCoord);

        if (direction == Direction.UP) {
            gameboard.removePeg(space.xCoord, space.yCoord + 1);
            gameboard.removePeg(space.xCoord, space.yCoord + 2);
        } else if (direction == Direction.DOWN) {
            gameboard.removePeg(space.xCoord, space.yCoord - 1);
            gameboard.removePeg(space.xCoord, space.yCoord - 2);
        } else if (direction == Direction.RIGHT) {
            gameboard.removePeg(space.xCoord + 1, space.yCoord);
            gameboard.removePeg(space.xCoord + 2, space.yCoord);
        } else {
            gameboard.removePeg(space.xCoord - 1, space.yCoord);
            gameboard.removePeg(space.xCoord - 2, space.yCoord);
        }
    }

    private static boolean moveMarble(ArrayList<Coordinate> blankSpaces) {
        // Iterate through every combo of blank spaces and directions
        while (true) {
            if (blankSpaces.isEmpty()) {
                return false;
            }

            Coordinate randomSpace = blankSpaces.get((int) (Math.random() * blankSpaces.size()));
            ArrayList<Direction> directions = Direction.getDirections();

            while (true) {
                if (directions.isEmpty()) {
                    blankSpaces.remove(randomSpace);
                    break;
                }

                Direction randomDirection = directions.get((int) (Math.random() * directions.size()));

                if (verifyMove(randomSpace, randomDirection)) {
                    directionList.push(randomDirection);
                    coordinateList.push(randomSpace);
                    executeMove(randomSpace, randomDirection);
                    return true;
                } else {
                    directions.remove(randomDirection);
                }
            }
        }
    }

    public static void runGame() {
        setUpGame();

        while (true) {
            ArrayList<Coordinate> blankSpaces = gameboard.getBlankSpaces();

            if (blankSpaces.size() == 32) {
                break;
            }

            boolean movedPiece = moveMarble(blankSpaces);

            if (!movedPiece) {
                System.out.println(directionList.size());
                setUpGame();
            }
        }

        for (int i = 0; i < 32; i++) {
            System.out.println(directionList.pop() + " -- " + coordinateList.peek().xCoord + "," + coordinateList.pop().yCoord);
        }
    }
}
