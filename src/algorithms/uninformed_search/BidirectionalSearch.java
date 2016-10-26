package algorithms.uninformed_search;

import algorithms.Algorithm;
import problems.Node;
import problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public class BidirectionalSearch extends Algorithm {
    private ArrayList<Node> f_goal;
    private ArrayList<Node> e_goal;

    @Override
    public Node apply(Problem problem, boolean isGraphy) {
        if (isGraphy) {
            f = new ArrayList<>();
            e = new ArrayList<>();
            f_goal = new ArrayList<>();
            e_goal = new ArrayList<>();
            f.add(problem.getInitialState());
            f_goal.add(problem.getGoalState());
            //Exception forever initial and goal is the same
            if (problem.isGoal(f.get(0))) return f.get(0);

            while (!f.isEmpty() && !f_goal.isEmpty()) {
                Node nodeInStartScope = f.remove(0);
                for (Node child : problem.nextState(nodeInStartScope)) {
                    //if (problem.isGoal(child)) return child;
                    if (f_goal.contains(child) || e_goal.contains(child)) return child;
                    if (!e.contains(child) && !f.contains(child) && !child.equals(nodeInStartScope))
                        f.add(child);
                }
                e.add(nodeInStartScope);

                Node nodeInGoalScope = f_goal.remove(0);
                for (Node child : problem.nextState(nodeInGoalScope)) {
                    //if (problem.isGoal(child)) return child;
                    if (f.contains(child) || e.contains(child)) return child;
                    if (!e_goal.contains(child) && !f_goal.contains(child) && !child.equals(nodeInGoalScope))
                        f_goal.add(child);
                }
                e_goal.add(nodeInGoalScope);

            }
        } else {
            f = new ArrayList<>();
            f_goal = new ArrayList<>();
            f.add(problem.getInitialState());
            f_goal.add(problem.getGoalState());
            //Exception forever initial and goal is the same
            if (problem.isGoal(f.get(0))) return f.get(0);

            while (!f.isEmpty() && !f_goal.isEmpty()) {
                Node nodeInStartScope = f.remove(0);
                for (Node child : problem.nextState(nodeInStartScope)) {
                    //if (problem.isGoal(child)) return child;
                    if (f_goal.contains(child)) return child;
                    if (!child.equals(nodeInStartScope))
                        f.add(child);
                }
                Node nodeInGoalScope = f_goal.remove(0);
                for (Node child : problem.nextState(nodeInGoalScope)) {
                    //if (problem.isGoal(child)) return child;
                    if (f.contains(child)) return child;
                    if (!child.equals(nodeInGoalScope))
                        f_goal.add(child);
                }
            }
        }
        return null;
    }
}
