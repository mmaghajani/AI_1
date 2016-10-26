package data_structures;

/**
 * Created by mma on 10/26/16.
 */
public class RobotNode extends Node {
    private int state ;

    public RobotNode(int state){
        this.state = state ;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
