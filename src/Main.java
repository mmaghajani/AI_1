import algorithms.informed_search.AStar;
import algorithms.uninformed_search.BidirectionalSearch;
import algorithms.uninformed_search.UniformCostSearch;
import algorithms.uninformed_search.dfs.UnlimitedDFS;
import problems.Robot;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by mma on 10/26/16.
 */
public class Main {
    public static void main(String[] args) {
        ProblemSolvingAgent agent = new ProblemSolvingAgent();
        configRobotProblem(agent) ;

    }

    private static void configRobotProblem(ProblemSolvingAgent agent) {
        ArrayList<Integer> horizontalWall = new ArrayList<>() ;
        horizontalWall.add(16);
        horizontalWall.add(17);
        ArrayList<Integer> verticalWall = new ArrayList<>() ;
        horizontalWall.add(9);
        horizontalWall.add(15);
        Robot robotProblem = new Robot(5 , 5 , horizontalWall , verticalWall) ;
        agent.configure(robotProblem, new UniformCostSearch());
        agent.solve(true);
        agent.configure(robotProblem, new UnlimitedDFS());
        agent.solve(true);
        agent.configure(robotProblem, new BidirectionalSearch());
        agent.solve(true);
        agent.configure(robotProblem, new AStar());
        agent.solve(true);
    }
}
