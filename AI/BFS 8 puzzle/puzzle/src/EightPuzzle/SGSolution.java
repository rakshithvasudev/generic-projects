package EightPuzzle;

//  SGSolution class    Creed Jones    CBU    CSC512 SP18    Jan 28, 2018
//   encapsulates the sequence of steps that solves the problem

import java.util.Stack;
import java.util.ArrayList;

public class SGSolution {
    ArrayList<SGAction> actions = new ArrayList<SGAction>();

    public SGSolution(){
    }

    public SGSolution(SGNode n) {
        Stack<SGNode> stk = new Stack<SGNode>();

        while(n.getParent() != null) {      // use a stack to get the nodes in reverse order
            stk.push(n);
            n = n.getParent();
        }

        while(!stk.isEmpty()) {             // form the array of actions
            n = stk.pop();
            actions.add(n.getAction());
        }
    }

    public int getLength() { return actions.size(); };

    public String toString() {
        String s = "";
        for (SGAction act : actions) {
            s += act.getMoveStr();
        }
        return s;
    }
}