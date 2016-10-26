package algorithms.uninformed_search;

import algorithms.Algorithm;
import data_structures.Node;
import problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public class UniformCostSearch extends Algorithm {
    @Override
    public Node apply(Problem problem, boolean isGraphy) {
        if (isGraphy) {
            f = new ArrayList<>();
            e = new ArrayList<>();
            f.add(problem.getInitialState());
            while (!f.isEmpty()) {
                Node node = getMinimumCost();
                if (problem.isGoal(node)) return node;

                for (Node child : problem.nextState(node)) {
                    if (!e.contains(child) && !f.contains(child) && !child.equals(node)) {
                        child.setAccessibilityCost(node.getAccessibilityCost() + problem.getCost(node, child));
                        f.add(child);
                    }
                    //updating node
                    if (f.contains(child)) {
                        int newCost = node.getAccessibilityCost() + problem.getCost(node, child) ;
                        if( newCost < f.get(f.indexOf(child)).getAccessibilityCost())
                            f.get(f.indexOf(child)).setAccessibilityCost(newCost);
                    }
                }
                e.add(node);
            }
        } else {
            f = new ArrayList<>();
            f.add(problem.getInitialState());
            while (!f.isEmpty()) {
                Node node = getMinimumCost();
                if (problem.isGoal(node)) return node;

                for (Node child : problem.nextState(node)) {
                    if ( !f.contains(child) && !child.equals(node)) {
                        child.setAccessibilityCost(node.getAccessibilityCost() + problem.getCost(node, child));
                        f.add(child);
                    }
                    //updating node
                    if (f.contains(child)) {
                        int newCost = node.getAccessibilityCost() + problem.getCost(node, child) ;
                        if( newCost < f.get(f.indexOf(child)).getAccessibilityCost())
                            f.get(f.indexOf(child)).setAccessibilityCost(newCost);
                    }
                }
            }
        }
        return null;
    }

    private Node getMinimumCost() {
        Node min = new Node();
        min.setAccessibilityCost(Integer.MAX_VALUE);
        for (Node node : f) {
            if (node.getAccessibilityCost() < min.getAccessibilityCost())
                min = node;
        }
        return min;
    }
}
