package algorithms.uninformed_search.dfs;

import data_structures.Node;
import problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public class IterativeDeepeningDFS extends DFS {
    private int limit = Integer.MAX_VALUE;

    @Override
    public Node apply(Problem problem, boolean isGraphy) {
        if (isGraphy) {
            limit = 0;
            while (true) {
                f = new ArrayList<>();
                e = new ArrayList<>();
                f.add(problem.getInitialState());

                //Exception forever initial and goal is the same
                if (problem.isGoal(f.get(0))) return f.get(0);

                while (!f.isEmpty()) {
                    Node node = f.remove(0);
                    increaseNumOfExpandedNode();
                    if (node.getDepth() < limit) {
                        for (Node child : problem.nextState(node)) {
                            if (problem.isGoal(child)){
                                child.setAccessibilityCost(node.getAccessibilityCost() + problem.getCost(node, child));
                                child.setParent(node);
                                return child;
                            }
                            if (!e.contains(child) && !f.contains(child) && !child.equals(node)) {
                                child.setAccessibilityCost(node.getAccessibilityCost() + problem.getCost(node, child));
                                child.setDepth(node.getDepth() + 1);
                                child.setParent(node);
                                increaseNumOfVisitedNode();
                                f.add(0, child);
                                if( getMaxUsedMemory() < f.size() )
                                    setMaxUsedMemory(f.size());
                            }
                        }
                        e.add(node);
                    }
                }
                limit++;
            }
        } else {
            limit = 0;
            while (true) {
                f = new ArrayList<>();
                f.add(problem.getInitialState());

                //Exception forever initial and goal is the same
                if (problem.isGoal(f.get(0))) return f.get(0);

                while (!f.isEmpty()) {
                    Node node = f.remove(0);
                    increaseNumOfExpandedNode();
                    if (node.getDepth() < limit) {
                        for (Node child : problem.nextState(node)) {
                            if (problem.isGoal(child)){
                                child.setAccessibilityCost(node.getAccessibilityCost() + problem.getCost(node, child));
                                child.setParent(node);
                                return child;
                            }
                            if (!child.equals(node)) {
                                child.setAccessibilityCost(node.getAccessibilityCost() + problem.getCost(node, child));
                                child.setDepth(node.getDepth() + 1);
                                child.setParent(node);
                                increaseNumOfVisitedNode();
                                f.add(0, child);
                                if( getMaxUsedMemory() < f.size() )
                                    setMaxUsedMemory(f.size());
                            }
                        }
                    }
                }
                limit++ ;
            }
        }
    }
}
