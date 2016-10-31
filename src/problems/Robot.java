package problems;

import data_structures.Node;
import data_structures.RobotNode;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public class Robot extends Problem {
    private int height, width;
    private ArrayList<Integer> horizontalWall, verticalWall;

    public Robot(int height, int width, ArrayList<Integer> horizontalWall, ArrayList<Integer> verticalWall) {
        this.height = height;
        this.width = width;
        this.horizontalWall = horizontalWall;
        this.verticalWall = verticalWall;
    }

    @Override
    public Node getInitialState() {
        RobotNode initialState = new RobotNode(0);
        return initialState;
    }

    @Override
    public ArrayList<Node> nextState(Node node) {
        ArrayList<Node> neighbours = new ArrayList<>();
        if ((int)((RobotNode) node).getState() - width >= 0 && notTopWall(node)) {
            RobotNode neighbour = new RobotNode((int)((RobotNode) node).getState() - width);
            neighbours.add(neighbour);
        }
        if ((int)((RobotNode) node).getState() + width < width * height && notBottomWall(node)) {
            RobotNode neighbour = new RobotNode((int)((RobotNode) node).getState() + width);
            neighbours.add(neighbour);
        }
        if ((int)((RobotNode) node).getState() % width != 0 && notLeftWall(node)) {
            RobotNode neighbour = new RobotNode((int)((RobotNode) node).getState() - 1);
            neighbours.add(neighbour);
        }
        if ((int)((RobotNode) node).getState() % width != width - 1 && notRightWall(node)) {
            RobotNode neighbour = new RobotNode((int)((RobotNode) node).getState() + 1);
            neighbours.add(neighbour);
        }
        return neighbours;
    }

    private boolean notBottomWall(Node node) {
        int x = (int)((RobotNode) node).getState();
        int row = x / width;
        int column = x % width;
        int wallNumber = row * (width) + column + width;
        if (horizontalWall.contains(wallNumber)) return false;
        else return true;
    }

    private boolean notTopWall(Node node) {
        int x = (int)((RobotNode) node).getState();
        int row = x / width;
        int column = x % width;
        int wallNumber = row * (width) + column;
        if (horizontalWall.contains(wallNumber)) return false;
        else return true;
    }

    private boolean notRightWall(Node node) {
        int x = (int)((RobotNode) node).getState();
        int row = x / width;
        int column = x % width;
        int wallNumber = row * (width + 1) + column + 1;
        if (verticalWall.contains(wallNumber)) return false;
        else return true;
    }

    private boolean notLeftWall(Node node) {
        int x = (int)((RobotNode) node).getState();
        int row = x / width;
        int column = x % width;
        int wallNumber = row * (width + 1) + column;
        if (verticalWall.contains(wallNumber)) return false;
        else return true;
    }

    @Override
    public boolean isGoal(Node node) {
        return (int)((RobotNode) node).getState() == width * height - 1;
    }

    @Override
    public int getCost(Node src, Node dest) {
        return 1;
    }

    @Override
    public double heuristicFunction(Node node) {
        int a = width - ((int)((RobotNode) node).getState() % width);
        int b = height - ((int)((RobotNode) node).getState() / width);
        double z = Math.sqrt(a * a + b * b);
        return z;
    }

    @Override
    public Node getGoalState() {
        return new RobotNode(width * height - 1);
    }
}
