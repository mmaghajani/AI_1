package problems;

import data_structures.Node;
import data_structures.QueensNode;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public class Queens extends Problem {
    @Override
    public Node getInitialState() {
        int[] state = new int[8];
        for (int i = 0; i < 8; i++)
            state[i] = 0;
        QueensNode node = new QueensNode(state);
        return node;
    }

    @Override
    public ArrayList<Node> nextState(Node node) {
        ArrayList<Node> next = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int[] state1 = ((QueensNode) node).getState();
            if (state1[i] > 0) {
                state1[i]--;
                QueensNode nextState = new QueensNode(state1);
                next.add(nextState);
            }
            int[] state2 = ((QueensNode) node).getState();
            if (state2[i] < 7) {
                state2[i]--;
                QueensNode nextState = new QueensNode(state2);
                next.add(nextState);
            }
        }
        return next;
    }

    @Override
    public boolean isGoal(Node node) {
        return isGaurd(node);
    }

    private boolean isGaurd(Node node) {
        int[] state = ((QueensNode) node).getState();
        int[] mark = new int[8];
        for (int i = 0; i < 8; i++)
            mark[i] = 0;
        for (int i = 0; i < 8; i++) {
            if (mark[state[i]] != 0)
                return false;
            else
                mark[state[i]] = 1;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (state[j] == state[i] - (j - i) || state[j] == state[i] + (j - i))
                    return false;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (state[j] == state[i] - (i - j) || state[j] == state[i] + (i - j))
                    return false;
            }
        }
        return true;
    }

    @Override
    public int getCost(Node src, Node dest) {
        return 1;
    }

    @Override
    public double heuristicFunction(Node node) {
        int counter = 0 ;
        int[] state = ((QueensNode) node).getState();
        int[] mark = new int[8];
        for (int i = 0; i < 8; i++)
            mark[i] = 0;
        for (int i = 0; i < 8; i++) {
            if (mark[state[i]] != 0)
                counter++ ;
            else
                mark[state[i]] = 1;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (state[j] == state[i] - (j - i) || state[j] == state[i] + (j - i))
                    counter++ ;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (state[j] == state[i] - (i - j) || state[j] == state[i] + (i - j))
                    counter++ ;
            }
        }
        return counter;
    }

    @Override
    public double getPathCost(Node node) {
        return node.getAccessibilityCost();
    }

    @Override
    public Node getGoalState() {
        return null;
    }
}
