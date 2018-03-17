package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Rakshith on 2/2/2018.
 */
public class BFS {

    Queue<Node> frontier;
    List<Node> explored;

    public BFS(){
        frontier = new LinkedList<>();
        explored = new ArrayList<>();
    }

    public void bfs(Node root){

        Node currentlyPopped;

        frontier.add(root);
        root.setVisited(true);
        explored.add(root);

        while (!frontier.isEmpty()){
            currentlyPopped = frontier.poll();

            for (Node neighbour:currentlyPopped.getNeighbours()) {

                if(!neighbour.isVisited()){
                    frontier.add(neighbour);
                    neighbour.setVisited(true);
                    explored.add(neighbour);
                }

            }

        }

        System.out.println(explored);
    }

}
