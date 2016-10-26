package problems;

import data_structures.Node;
import data_structures.RobotNode;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public class Robot extends Problem {
    private int height, width;

    public Robot(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public Node getInitialState() {
        RobotNode initialState = new RobotNode(0);
        return initialState;
    }

    @Override
    public ArrayList<Node> nextState(Node node) {
        ArrayList<Node> neighbours = new ArrayList<>();
        if (((RobotNode) node).getState() - width >= 0) {
            RobotNode neighbour = new RobotNode(((RobotNode) node).getState() - width);
            neighbours.add(neighbour);
        }
        if (((RobotNode) node).getState() + width < width * height) {
            RobotNode neighbour = new RobotNode(((RobotNode) node).getState() + width);
            neighbours.add(neighbour);
        }
        if (((RobotNode) node).getState() % width != 0) {
            RobotNode neighbour = new RobotNode(((RobotNode) node).getState() - 1);
            neighbours.add(neighbour);
        }
        if (((RobotNode) node).getState() % width != width - 1) {
            RobotNode neighbour = new RobotNode(((RobotNode) node).getState() + 1);
            neighbours.add(neighbour);
        }
        return neighbours;
    }

    @Override
    public boolean isGoal(Node node) {
        return ((RobotNode) node).getState() == width * height - 1;
    }

    @Override
    public int getCost(Node src, Node dest) {
        return 1;
    }

    @Override
    public double heuristicFunction(Node node) {
        int a = width - (((RobotNode) node).getState() % width);
        int b = height - (((RobotNode) node).getState() / width) ;
        double z = Math.sqrt(a*a + b*b) ;
        return z;
    }

    @Override
    public double getPathCost(Node node) {
        return node.getAccessibilityCost();
    }

    @Override
    public Node getGoalState() {
        return new RobotNode(width*height-1);
    }
}
