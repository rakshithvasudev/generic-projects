package BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rakshith on 2/2/2018.
 */
public class Node {

    private int data;
    private List<Node> neighbours;
    private boolean visited;


    public Node(int data) {
        this.data = data;
        neighbours = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addNeighbour(Node neighbour){
        neighbours.add(neighbour);
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
