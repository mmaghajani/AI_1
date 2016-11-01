package data_structures;

/**
 * Created by mma on 10/26/16.
 */
public class QueensNode extends Node {
    private int[] state = new int[8];

    public QueensNode(int[] state) {
        this.state = state;
    }
    @Override
    public Object getState() {
        return state;
    }

    public void setState(int[] state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        for( int i = 0 ; i < 8 ; i++ ){
            if( state[i] != ((QueensNode)o).state[i])
                return false ;
        }
        return true ;
    }

    @Override
    public String toString() {
        return "[" + state[0] + " ," + state[1] + " ," + state[2] + " ," +
                state[3] + " ," + state[4] + " ," + state[5] + " ," + state[6] + " ," + state[7] + "]" ;
    }
}
