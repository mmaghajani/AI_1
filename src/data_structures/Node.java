package data_structures;

/**
 * Created by mma on 10/26/16.
 */
public class Node {
    protected int accessibilityCost ;
    protected int depth = 0 ;
    protected Node parent = null ;

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

    public void setParent(Node parent){
        this.parent = parent ;
    }

    public Node getParent(){
        return parent ;
    }
}
