package problems;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public class Queens extends Problem {
    @Override
    public Node getInitialState() {
        return null;
    }

    @Override
    public ArrayList<Node> nextState(Node node) {
        return null;
    }

    @Override
    public boolean isGoal(Node node) {
        return false;
    }

    @Override
    public int getCost(Node src, Node dest) {
        return 0;
    }

    @Override
    public int heuristicFunction(Node node) {
        return 0;
    }

    @Override
    public int getPathCost(Node node) {
        return 0;
    }

    @Override
    public Node getGoalState() {
        return null;
    }
}
