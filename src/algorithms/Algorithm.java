package algorithms;


import problems.Problem;

import java.util.ArrayList;

/**
 * Created by mma on 10/26/16.
 */
public abstract class Algorithm {
    protected ArrayList<Node> f ;
    protected ArrayList<Node> e ;
    protected Problem problem ;

    public abstract void apply() ;
}
