package problems;

/**
 * Created by mma on 10/26/16.
 */
public class Node {
    private int accessibilityCost ;
    private int depth = 0 ;

    public Node(){

    }

    public int getAccessibilityCost() {
        return accessibilityCost;
    }

    public void setAccessibilityCost(int accessibilityCost) {
        this.accessibilityCost = accessibilityCost;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
