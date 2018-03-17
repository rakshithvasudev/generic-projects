from Basicbfs.BFS import BFS
from Basicbfs.Node import Node


class Main:
    if __name__ == '__main__':
        n1 = Node(1)
        n2 = Node(2)
        n3 = Node(3)
        n4 = Node(4)
        n5 = Node(5)
        n6 = Node(6)
        n7 = Node(7)
        n8 = Node(8)
        n9 = Node(9)

        n1.add_neighbour(n2)
        n1.add_neighbour(n3)
        n3.add_neighbour(n4)
        n1.add_neighbour(n5)
        n2.add_neighbour(n6)
        n3.add_neighbour(n7)
        n3.add_neighbour(n1)
        n5.add_neighbour(n9)

        bfs = BFS()

        sequence = bfs.bfs(n1, 9)

        for node in sequence:
            print(node)

            # nodes = [n1, n2, n3, n4, n5, n6, n7]
            # popped_node = nodes.pop(0)
            # print(popped_node)
