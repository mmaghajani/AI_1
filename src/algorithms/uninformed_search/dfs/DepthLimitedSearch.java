package algorithms.uninformed_search.dfs;

import problems.Node;
import problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public class DepthLimitedSearch extends DFS {
    private int limit = Integer.MAX_VALUE;

    @Override
    public Node apply(Problem problem, boolean isGraphy) {
        if (isGraphy) {
            f = new ArrayList<>();
            e = new ArrayList<>();
            f.add(problem.getInitialState());

            //Exception forever initial and goal is the same
            if (problem.isGoal(f.get(0))) return f.get(0);

            while (!f.isEmpty()) {
                Node node = f.remove(0);
                if (node.getDepth() < limit) {
                    for (Node child : problem.nextState(node)) {
                        if (problem.isGoal(child)) return child;
                        if (!e.contains(child) && !f.contains(child) && !child.equals(node)) {
                            child.setDepth(node.getDepth() + 1);
                            f.add(0, child);
                        }
                    }
                    e.add(node);
                }
            }
        } else {
            f = new ArrayList<>();
            f.add(problem.getInitialState());

            //Exception forever initial and goal is the same
            if (problem.isGoal(f.get(0))) return f.get(0);

            while (!f.isEmpty()) {
                Node node = f.remove(0);
                if (node.getDepth() < limit) {
                    for (Node child : problem.nextState(node)) {
                        if (problem.isGoal(child)) return child;
                        if (!child.equals(node)) {
                            child.setDepth(node.getDepth() + 1);
                            f.add(0, child);
                        }
                    }
                }
            }
        }
        return null;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
