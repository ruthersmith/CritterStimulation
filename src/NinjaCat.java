import java.awt.*;

public class NinjaCat extends Critter {
    @Override
    public Color getColor() {
        return Color.MAGENTA;
    }

    @Override
    public String toString() {
        return "NC";
    }
    public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.EMPTY){
          return Action.HOP;
      }else if (info.frontThreat()){
          return  Action.INFECT;
      }
      return Action.LEFT;
    }
}
