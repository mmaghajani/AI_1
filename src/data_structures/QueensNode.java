package data_structures;

/**
 * Created by mma on 10/26/16.
 */
public class QueensNode extends Node {
    private int[] state = new int[8];

    public QueensNode(int[] state) {
        this.state = state;
    }

    public int[] getState() {
        return state;
    }

    public void setState(int[] state) {
        this.state = state;
    }
}
