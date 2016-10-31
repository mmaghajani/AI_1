package problems;

import data_structures.Node;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public abstract class Problem {
    public abstract Node getInitialState();

    public abstract ArrayList<Node> nextState(Node node);

    public abstract boolean isGoal(Node node);

    public abstract int getCost(Node src, Node dest);

    public abstract double heuristicFunction(Node node);

    public abstract Node getGoalState();

    public double getPathCost(Node node){
        if(node == null )   return Double.MAX_VALUE ;
        return node.getAccessibilityCost() ;
    }

    public double evaluateFunction(Node node){
        if( node == null )  return Double.MAX_VALUE ;
        return heuristicFunction(node) + getPathCost(node) ;
    }
}
