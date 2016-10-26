package problems;

import algorithms.Node;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by mma on 10/26/16.
 */
public abstract class Problem {
    public abstract Node getInitialState();

    public abstract ArrayList<Node> nextState(Node node);

    public abstract boolean isGoal(Node node);

    public abstract int getCost(Map<Node, Node> step);

    public abstract int heuristicFunction(Node node);
}
