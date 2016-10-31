package algorithms.informed_search;

import algorithms.Algorithm;
import data_structures.Node;
import problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public class AStar extends Algorithm {
    @Override
    public Node apply(Problem problem, boolean isGraphy) {
        if (isGraphy) {
            f = new ArrayList<>();
            e = new ArrayList<>();

            while (!f.isEmpty()) {
                Node node = getMinimumCost(problem);
                increaseNumOfExpandedNode();
                if (problem.isGoal(node)) return node;

                for (Node child : problem.nextState(node)) {
                    if (!e.contains(child) && !f.contains(child) && !child.equals(node)) {
                        child.setAccessibilityCost(node.getAccessibilityCost() + problem.getCost(node, child));
                        child.setParent(node);
                        increaseNumOfVisitedNode();
                        f.add(child);
                    }
                    //updating node
                    if (f.contains(child)) {
                        int newCost = node.getAccessibilityCost() + problem.getCost(node, child);
                        if (newCost < f.get(f.indexOf(child)).getAccessibilityCost())
                            f.get(f.indexOf(child)).setAccessibilityCost(newCost);
                    }
                }
                e.add(node);
            }
        } else {
            f = new ArrayList<>();

            while (!f.isEmpty()) {
                Node node = getMinimumCost(problem);
                increaseNumOfExpandedNode();
                if (problem.isGoal(node)) return node;

                for (Node child : problem.nextState(node)) {
                    if (!f.contains(child) && !child.equals(node)) {
                        child.setAccessibilityCost(node.getAccessibilityCost() + problem.getCost(node, child));
                        child.setParent(node);
                        increaseNumOfVisitedNode();
                        f.add(child);
                    }
                    //updating node
                    if (f.contains(child)) {
                        int newCost = node.getAccessibilityCost() + problem.getCost(node, child);
                        if (newCost < f.get(f.indexOf(child)).getAccessibilityCost())
                            f.get(f.indexOf(child)).setAccessibilityCost(newCost);
                    }
                }
            }
        }
        return null;
    }

    private Node getMinimumCost(Problem problem) {
        Node min = null;
        for (Node node : f) {
            if (problem.evaluateFunction(node) < problem.evaluateFunction(min))
                min = node;
        }
        f.remove(min);
        return min;
    }
}
