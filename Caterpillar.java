package assignment2;

public class Caterpillar extends MyDoublyLinkedList<Position> {
    private Position pI;
    private int size;

    public Caterpillar() {
        super();
        pI = new Position(7,7);
        this.addFirst(pI);
        size = 1;
    }

    public Position getHead() {
        return this.peekFirst();
    }

    public void eat(Position p) {
        if (Math.abs(p.getX()-this.getHead().getX())==1 && p.getY()==this.getHead().getY()) {
            this.addFirst(p);
        } else if (p.getX()==this.getHead().getX() && Math.abs(p.getY()-this.getHead().getY())==1) {
            this.addFirst(p);
        } else {
            throw new IllegalArgumentException("You can only move to an adjacent position.");
        }
    }

    public void move(Position p) {
        if (Math.abs(p.getX()-this.getHead().getX())==1 && p.getY()==this.getHead().getY()) {
            this.addFirst(p);
            this.removeLast();
        } else if (p.getX()==this.getHead().getX() && Math.abs(p.getY()-this.getHead().getY())==1) {
            this.addFirst(p);
            this.removeLast();
        } else {
            throw new IllegalArgumentException("You can only move to an adjacent position.");
        }
    }

    public boolean selfCollision(Position p) {
        for (Position element: this) {
            if (p.equals(element)) {
                return true;
            }
        }
        return false;
    }
}
