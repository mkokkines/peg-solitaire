import java.util.ArrayList;

public enum Direction {
    UP, DOWN, RIGHT, LEFT;

    static ArrayList<Direction> getDirections() {
        ArrayList<Direction> directions = new ArrayList<Direction>();

        directions.add(UP);
        directions.add(DOWN);
        directions.add(LEFT);
        directions.add(RIGHT);

        return directions;
    }
}
