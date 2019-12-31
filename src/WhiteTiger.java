import java.awt.*;

public class WhiteTiger extends Tiger {

    private  boolean infectedAnotherCritter;

    public WhiteTiger() {
        super();
        this.infectedAnotherCritter = false;
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    @Override
    public String toString() {
        if (infectedAnotherCritter){
            return super.toString();
        }else {
            return  "tgr";
        }
    }

    @Override
    public Action getMove(CritterInfo info) {
        Action move = super.getMove(info);
        if (!infectedAnotherCritter && move == Action.INFECT){
            infectedAnotherCritter = true;
        }
        return move;
    }
}
