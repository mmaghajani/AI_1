package data_structures;

/**
 * Created by mma on 10/26/16.
 */
public class RobotNode extends Node {
    private int state ;

    public RobotNode(int state){
        this.state = state ;
    }

    public Object getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        return state == ((RobotNode)o).state ;
    }
}
