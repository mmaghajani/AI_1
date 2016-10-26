package algorithms;


import problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public abstract class Algorithm {
    protected ArrayList<Node> f ;
    protected ArrayList<Node> e ;

    public abstract void apply(Problem problem , boolean isGraphy) ;
}
