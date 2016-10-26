package problems;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public abstract class Problem {
    public abstract Node getInitialState();

    public abstract ArrayList<Node> nextState(Node node);

    public abstract boolean isGoal(Node node);

    public abstract int getCost(Node src, Node dest);

    public abstract int heuristicFunction(Node node);

    public abstract int getPathCost(Node node) ;

    public abstract Node getGoalState();
}
