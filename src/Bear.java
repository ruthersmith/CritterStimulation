import java.awt.*;

public class Bear extends Critter {
    private Boolean polar;
    private Boolean isSlash;

    public Bear(Boolean polar) {
        this.polar = polar;
        this.isSlash = true;
    }

    @Override
    public Color getColor(){
        if (polar){
            return Color.white;
        }
        return Color.BLACK;
    }

    @Override
    public String toString() {
        if (isSlash){
            return "/";
        }
        return "\\";
    }

//  always infect if an enemy is in front, otherwise hop if possible, otherwise turn left.
    @Override
    public Action getMove(CritterInfo info) {
        isSlash = !isSlash;
        if (info.frontThreat()) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }
        return Action.LEFT;
    }
}
