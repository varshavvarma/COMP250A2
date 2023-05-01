package assignment2;

public class World {
    private Caterpillar caterpillar;
    private Position curFoodPos;
    private Region region;
    private ActionQueue cAction;
    private TargetQueue foodPos;
    private GameState GS;

    public World(TargetQueue tq, ActionQueue aq) {
        caterpillar = new Caterpillar();
        region = new Region(0,0,15,15);
        cAction = aq;
        foodPos = tq;
        GS = GameState.MOVE;
        curFoodPos = foodPos.dequeue();
    }

    public void step() {
        if (cAction.isEmpty()) {
            GS = GameState.NO_MORE_ACTION;
        } else if (this.isRunning()){
            Direction moveTo = cAction.dequeue();
            Position tempP = new Position(caterpillar.getHead());
            if (moveTo==Direction.NORTH) {
                tempP.moveNorth();
            } else if(moveTo==Direction.SOUTH) {
                tempP.moveSouth();
            } else if (moveTo==Direction.WEST) {
                tempP.moveWest();
            } else if (moveTo==Direction.EAST) {
                tempP.moveEast();
            }
            if (!region.contains(tempP)) {
                GS = GameState.WALL_COLLISION;
            } else if (caterpillar.selfCollision(tempP)){
                GS = GameState.SELF_COLLISION;
            } else if (curFoodPos.equals(tempP)){
                caterpillar.eat(tempP);
                GS = GameState.EAT;
                if (foodPos.isEmpty()) {
                    GS = GameState.DONE;
                } else {
                    curFoodPos = foodPos.dequeue();
                }
            } else {
                caterpillar.move(tempP);
                GS = GameState.MOVE;
            }
        }
    }

    public GameState getState() {
        return GS;
    }

    public Caterpillar getCaterpillar() {
        return caterpillar;
    }

    public Position getFood() {
        return curFoodPos;
    }

    public boolean isRunning() {
        if(GS==GameState.MOVE || GS==GameState.EAT) {
            return true;
        }
        return false;
    }
}
