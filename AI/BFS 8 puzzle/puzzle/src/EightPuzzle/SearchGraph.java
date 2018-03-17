package EightPuzzle;

import java.util.*;

public class SearchGraph {

    public static final int TESTDATA = 1;

    public SGSolution breadthFirstSearch(SGProblem p) {  // as discussed on page 82
        LinkedList<SGNode> frontier = new LinkedList<SGNode>();
        LinkedList<SGState> explored = new LinkedList<SGState>();

       SGNode node = new SGNode(new SGState(),null,new SGAction("U"),0);
       if (p.goalTest(node.getState())){
           return new SGSolution(node);
       }

       frontier.add(node);
       while (!frontier.isEmpty()){
           node = frontier.pop();
           explored.add(node.getState());

           for (SGAction currentAction : p.allowedActions(node.getState())) {

            SGNode child = new SGNode(new SGState(),null,new SGAction("U"),0).
                    childNode(p,currentAction);

            if (!explored.contains(child.getState()) || !frontier.contains(child)){

              if(p.goalTest(child.getState())){
                  return new SGSolution(child);
              }
              frontier.add(child);
            }

           }

       }

        return null;
    }

    public SGSolution uniformCostSearch(SGProblem p) {     // as discussed on page 84
        final int INITIALSIZE = 1000;       // arbitrary - will resize if needed

        PriorityQueue<SGNode> frontier =
                new PriorityQueue<SGNode>(INITIALSIZE, new SGNode.SortByCost());
        LinkedList<SGState> explored = new LinkedList<SGState>();

        SGNode node = new SGNode(new SGState(),null,new SGAction("U"),0);

        frontier.add(node);

        while (!frontier.isEmpty()){

            node = frontier.poll();

            if (p.goalTest(node.getState())){
                return new SGSolution(node);
            }
            explored.add(node.getState());

            for (SGAction currentAction:p.allowedActions(node.getState())) {
                SGNode child = new SGNode(new SGState(), null, new SGAction("U"), 0).
                        childNode(p, currentAction);


                if (frontier.size() > 0) {
                    // get the elements of priority queue
                    List<SGNode> sgNodeList = new ArrayList<>(frontier);

                    //search for the required elements
                    int requiredChildIndex = sgNodeList.indexOf(child);

                    //get the required element cost
                    int requiredElementPathCost = sgNodeList.get(requiredChildIndex).getCost();

                    if (!explored.contains(child.getState()) || !frontier.contains(child)) {
                        frontier.add(child);
                    }


                    // if child .STATE is in frontier with higher PATH-COST then
                    // replace that frontier node with child
                    else if (frontier.contains(child) && child.getCost() > requiredElementPathCost) {
                        // My approach to replace elements in the Priority queue:

                        // 1. Convert Priority Queue to list.
                        List<SGNode> tempList = new ArrayList<>(frontier);

                        // 2. replace elements as needed.
                        tempList.set(requiredChildIndex, child);

                        // 3. Convert list back to priority queue
                        frontier = new PriorityQueue<>(tempList);

                    }

                }

            }
        }
        return null;
    }


    public static void main(String[] args) {
        SearchGraph sg = new SearchGraph();

        SGSolution soln = sg.uniformCostSearch(new SGProblem());
//          SGSolution soln = sg.breadthFirstSearch(new SGProblem());

          if (soln == null){
              System.out.println("Sorry! No solution was found");
          }
          else{
            System.out.println("Solution is " + soln.getLength() + " long;");
            System.out.println(soln.toString());
          }

    }
}

