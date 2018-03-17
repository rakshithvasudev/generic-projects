package EightPuzzle;

import java.util.ArrayList;

public class SGProblem {
    public SGState result(SGState stt, SGAction m) {
        return stt.move(m.getMoveStr());
    }

    public Integer calcCost(SGState stt, SGAction m) {
        return 1;       // all moves cost one
    }

    public boolean goalTest(SGState stt) {      // the state class checks the board to see if we are done
        return stt.checkDone();
    }

    public ArrayList<SGAction> allowedActions(SGState stt) {    // returns array list of allowed actions for this state
        ArrayList<SGAction> sA = new ArrayList<SGAction>();
        int incr = 0;
        if (stt.isAllowed("u"))
            sA.add(new SGAction("u"));
        if (stt.isAllowed("d"))
            sA.add(new SGAction("d"));
        if (stt.isAllowed("l"))
            sA.add(new SGAction("l"));
        if (stt.isAllowed("r"))
            sA.add(new SGAction("r"));
        return sA;
    }
}