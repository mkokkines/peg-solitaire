import java.util.Objects;

public class Coordinate {
    int xCoord;
    int yCoord;

    public Coordinate(int setX, int setY) {
        xCoord = setX;
        yCoord = setY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Coordinate that = (Coordinate) o;

        return xCoord == that.xCoord &&
                yCoord == that.yCoord;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoord, yCoord);
    }
}
