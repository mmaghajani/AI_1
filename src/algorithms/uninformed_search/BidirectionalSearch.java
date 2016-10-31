package algorithms.uninformed_search;

import algorithms.Algorithm;
import data_structures.Node;
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
                increaseNumOfExpandedNode();
                for (Node child : problem.nextState(nodeInStartScope)) {
                    //if (problem.isGoal(child)) return child;
                    if (f_goal.contains(child) || e_goal.contains(child)) {
                        child.setAccessibilityCost(nodeInStartScope.getAccessibilityCost() + problem.getCost(nodeInStartScope, child));
                        child.setParent(nodeInStartScope);
                        //reversing
                        Node p = null, w = null;
                        int tempCost = 0;
                        if (f_goal.contains(child)) {
                            for (Node node : f_goal) {
                                if (node.equals(child)) {
                                    tempCost = node.getAccessibilityCost() + child.getAccessibilityCost();
                                    p = node;
                                    w = child;
                                    while (!problem.isGoal(w)) {
                                        Node q = p.getParent();
                                        p.setParent(w);
                                        w = p;
                                        p = q;
                                    }
                                }
                            }
                        } else if (e_goal.contains(child)) {
                            for (Node node : e_goal) {
                                if (node.equals(child)) {
                                    p = node;
                                    w = child;
                                    while (problem.isGoal(w)) {
                                        Node q = p.getParent();
                                        p.setParent(w);
                                        q.setParent(p);
                                        w = p;
                                        p = q;
                                    }
                                }
                            }
                        }
                        w.setAccessibilityCost(tempCost);
                        return w;
                    }
                    if (!e.contains(child) && !f.contains(child) && !child.equals(nodeInStartScope)) {
                        child.setAccessibilityCost(nodeInStartScope.getAccessibilityCost() + problem.getCost(nodeInStartScope, child));
                        child.setParent(nodeInStartScope);
                        increaseNumOfVisitedNode();
                        f.add(child);
                    }
                }
                e.add(nodeInStartScope);

                Node nodeInGoalScope = f_goal.remove(0);
                increaseNumOfExpandedNode();
                for (Node child : problem.nextState(nodeInGoalScope)) {
                    //if (problem.isGoal(child)) return child;
                    if (f.contains(child) || e.contains(child)) {
                        child.setAccessibilityCost(nodeInGoalScope.getAccessibilityCost() + problem.getCost(nodeInGoalScope, child));
                        child.setParent(nodeInGoalScope);
                        //reversing
                        Node p = null, w = null;
                        int tempCost = 0;
                        if (f.contains(child)) {
                            for (Node node : f) {
                                if (node.equals(child)) {
                                    p = child;
                                    w = node;
                                    tempCost = node.getAccessibilityCost() + child.getAccessibilityCost();
                                    while (!problem.isGoal(w)) {
                                        Node q = p.getParent();
                                        p.setParent(w);
                                        w = p;
                                        p = q;
                                    }
                                }
                            }
                        } else if (e.contains(child)) {
                            for (Node node : e) {
                                if (node.equals(child)) {
                                    p = child;
                                    w = node;
                                    while (problem.isGoal(w)) {
                                        Node q = p.getParent();
                                        p.setParent(w);
                                        q.setParent(p);
                                        w = p;
                                        p = q;
                                    }
                                }
                            }
                        }
                        w.setAccessibilityCost(tempCost);
                        return w;
                    }
                    if (!e_goal.contains(child) && !f_goal.contains(child) && !child.equals(nodeInGoalScope)) {
                        child.setAccessibilityCost(nodeInGoalScope.getAccessibilityCost() + problem.getCost(nodeInGoalScope, child));
                        child.setParent(nodeInGoalScope);
                        increaseNumOfVisitedNode();
                        f_goal.add(child);
                    }
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
                increaseNumOfExpandedNode();
                for (Node child : problem.nextState(nodeInStartScope)) {
                    //if (problem.isGoal(child)) return child;
                    if (f_goal.contains(child)) {
                        child.setAccessibilityCost(nodeInStartScope.getAccessibilityCost() + problem.getCost(nodeInStartScope, child));
                        child.setParent(nodeInStartScope);
                        //reversing
                        Node p = null, w = null;
                        int tempCost = 0;
                        if (f_goal.contains(child)) {
                            for (Node node : f_goal) {
                                if (node.equals(child)) {
                                    p = node;
                                    w = child;
                                    tempCost = node.getAccessibilityCost() + child.getAccessibilityCost();
                                    while (!problem.isGoal(w)) {
                                        Node q = p.getParent();
                                        p.setParent(w);
                                        w = p;
                                        p = q;
                                    }
                                }
                            }
                        }
                        w.setAccessibilityCost(tempCost);
                        return w;
                    }
                    if (!child.equals(nodeInStartScope)) {
                        child.setParent(nodeInStartScope);
                        increaseNumOfVisitedNode();
                        f.add(child);
                    }
                }
                Node nodeInGoalScope = f_goal.remove(0);
                for (Node child : problem.nextState(nodeInGoalScope)) {
                    //if (problem.isGoal(child)) return child;
                    if (f.contains(child)) {
                        child.setAccessibilityCost(nodeInGoalScope.getAccessibilityCost() + problem.getCost(nodeInGoalScope, child));
                        child.setParent(nodeInStartScope);
                        //reversing
                        Node p = null, w = null;
                        int tempCost = 0;
                        if (f.contains(child)) {
                            for (Node node : f) {
                                if (node.equals(child)) {
                                    p = child;
                                    w = node;
                                    tempCost = node.getAccessibilityCost() + child.getAccessibilityCost();
                                    while (!problem.isGoal(w)) {
                                        Node q = p.getParent();
                                        p.setParent(w);
                                        w = p;
                                        p = q;
                                    }
                                }
                            }
                        }
                        w.setAccessibilityCost(tempCost);
                        return w;
                    }
                    if (!child.equals(nodeInGoalScope)) {
                        child.setAccessibilityCost(nodeInGoalScope.getAccessibilityCost() + problem.getCost(nodeInGoalScope, child));
                        child.setParent(nodeInGoalScope);
                        increaseNumOfVisitedNode();
                        f_goal.add(child);
                    }
                }
            }
        }
        return null;
    }
}
