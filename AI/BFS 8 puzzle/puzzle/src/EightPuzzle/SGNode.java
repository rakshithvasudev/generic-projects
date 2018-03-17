package EightPuzzle;//  SGNode class    Creed Jones    CBU    CSC512 SP18    Jan 28, 2018
//   a single node in the solution graph - specifics are in the State class


import EightPuzzle.SGAction;

import java.util.Comparator;

public class SGNode {
    SGState state;
    SGNode parent;
    SGAction action;
    Integer cost;

    public SGNode(SGState inS, SGNode inP, SGAction inA, Integer inC) {
        state = inS;
        parent = inP;
        action = inA;
        cost = inC;
    }

    public SGState getState() { return state; }

    public Integer getCost() { return cost; }

    public SGNode getParent() { return parent; }

    public SGAction getAction() { return action; }

    public SGNode childNode(SGProblem p, SGAction action) {     // as stated in the book on page 79
        SGState s = p.result(this.getState(), action);
        int c = this.getCost() + p.calcCost(this.getState(), action);
        return new SGNode(s, this, action, c);
    }

    public static class SortByCost implements Comparator<SGNode>    // to support the priority queue
    {
        public int compare(SGNode a, SGNode b)
        {
            return a.cost - b.cost;
        }
    }
}
