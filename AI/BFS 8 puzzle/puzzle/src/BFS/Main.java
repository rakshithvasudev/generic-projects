package BFS;

/**
 * Created by Rakshith on 2/2/2018.
 */
public class Main {

    public static void main(String[] args) {
        BFS bfs =  new BFS();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

//        n1.addNeighbour(n2);
//        n1.addNeighbour(n3);
//        n2.addNeighbour(n4);
//        n2.addNeighbour(n5);
//        n3.addNeighbour(n6);
//        n3.addNeighbour(n7);


        n3.addNeighbour(n5);
        n3.addNeighbour(n7);
        bfs.bfs(n3);




    }

}
