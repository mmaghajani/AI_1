package algorithms;


import data_structures.Node;
import problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public abstract class Algorithm {
    protected ArrayList<Node> f ;
    protected ArrayList<Node> e ;

    public abstract Node apply(Problem problem , boolean isGraphy) ;
}
