import algorithms.Algorithm;
import data_structures.Node;
import problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 10/31/16.
 */
public class ResponseFormatter {
    private static ResponseFormatter ourInstance = new ResponseFormatter();

    public static ResponseFormatter getInstance() {
        return ourInstance;
    }

    private ResponseFormatter() {
    }

    public void format(ProblemSolvingAgent agent, Node goal) {
        Algorithm algorithm = agent.getSearchAlgorithm();
        String seperator = "----------------------";
        System.out.println(seperator);
        System.out.println("number of expanded nodes : " + algorithm.getNumOfExpandedNode());
        System.out.println("number of visited nodes : " + algorithm.getNumOfVisitedNode());
        System.out.println("number of max used memory : " + algorithm.getMaxUsedMemory());
        System.out.println(seperator);
        System.out.println("Cost of goal : " + goal.getAccessibilityCost() + "\n\n\n");
        Node node = goal;
        ArrayList<Node> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.getParent();
        }

        for (int i = path.size(); i >= 0; i--) {
            System.out.println(path.get(i));
        }
    }
}
