package assignment2;

public class Position {
    private int xCoord;
    private int yCoord;

    public Position(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public Position(Position p) {
        this.xCoord = p.xCoord;
        this.yCoord = p.yCoord;
    }

    public void reset(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public void reset(Position p) {
        this.xCoord = p.xCoord;
        this.yCoord = p.yCoord;
    }

    public static int getDistance(Position p1, Position p2) {
        int xDist = Math.abs(p1.xCoord - p2.xCoord);
        int yDist = Math.abs(p1.yCoord - p2.yCoord);
        return (int) (Math.sqrt(Math.pow(xDist,2) + Math.pow(yDist,2)));
    }

    public int getX() {
        return this.xCoord;
    }

    public int getY() {
        return this.yCoord;
    }

    public void moveWest() {
        xCoord--;
    }

    public void moveEast() {
        xCoord++;
    }

    public void moveNorth() {
        yCoord--;
    }

    public void moveSouth() {
        yCoord++;
    }

    public boolean equals(Object o) {
        if (o instanceof Position) {
            Position p = (Position) o;
            if (p.xCoord==this.xCoord && p.yCoord==this.yCoord) {
                return true;
            }
        }
        return false;
    }
}
