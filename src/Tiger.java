import java.awt.*;
import java.util.Random;

public class Tiger extends Critter {

    private final Color[] MY_COLORS = {Color.RED, Color.GREEN, Color.BLUE};
    private int remainingColorUse;
    private int index;
    private Random randomColorchoser;

    public Tiger() {
        this.remainingColorUse = 0;
        this.randomColorchoser = new Random();
    }

    @Override
    public Color getColor(){
        if (remainingColorUse == 0){
            chooseNewColor(2,3);
        }else {
            remainingColorUse--;
        }
        return MY_COLORS[index];
    }

    private void chooseNewColor(int additionalUse,int bound){
        remainingColorUse = additionalUse;
        index = randomColorchoser.nextInt(bound);
    }

//    always infect if an enemy is in front, otherwise if a wall is in front or to the right, then turn left,
//    otherwise if a fellow Tiger is in front, then turn right, otherwise hop.
    @Override
    public Action getMove(CritterInfo info) {
        if (info.frontThreat()){
            return Action.INFECT;
        }else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
            return Action.LEFT;
        }else if (info.getFront() == Neighbor.SAME){
            return Action.RIGHT;
        }else{
            return Action.HOP;
        }
    }

    @Override
    public String toString() {
        return "TGR";
    }
}
