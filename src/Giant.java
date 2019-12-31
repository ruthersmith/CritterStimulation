import java.awt.*;

public class Giant extends Critter {

    private final String[] MY_STRINGS = {"fee","fie","foe","fum"};
    private int index;
    private int remainingUseOfIndex;

    public Giant() {
        this.index = 0;
        this.remainingUseOfIndex = 6;
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

//    "fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves, then "fum" for 6 moves, then repeat.
    @Override
    public String toString() {
      if (remainingUseOfIndex == 0){
          index = (index + 1) % MY_STRINGS.length;
          remainingUseOfIndex = 6;
      }
      remainingUseOfIndex--;
      return MY_STRINGS[index];
    }

//    always infect if an enemy is in front, otherwise hop if possible, otherwise turn right.
    @Override
    public Action getMove(CritterInfo info) {
        if (info.frontThreat()){
            return Action.INFECT;
        }else if (info.getFront() == Neighbor.EMPTY){
           return Action.HOP;
        }else {
            return Action.RIGHT;
        }
    }
}
