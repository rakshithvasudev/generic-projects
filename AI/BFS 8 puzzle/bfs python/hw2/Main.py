from hw2.Node import Node
from hw2.Search import Search
import time
from random import *
from itertools import permutations


class Main:
    if __name__ == '__main__':

        # define the goal state
        g_state = "321456087"

        # Generates all possible states for nodes
        all_node_values = ["".join(p) for p in list(permutations("012345678"))]
        nodes = []

        # generate all the nodes and add it to the nodes list
        for node_state in all_node_values:
            new_node = Node(node_state)
            new_node.set_cost(randint(0, 10))
            nodes.append(new_node)

        # generate node number of random ints starting from 0
        unique_random_numbers = [i for i in range(len(nodes))]
        shuffle(unique_random_numbers)

        # setup the neighbours in a random fashion
        counter = 0
        for node in nodes:
            nodes[0].add_neighbour(node)
            counter += 1

        # initialize the kind of search
        search_method = Search()
        start_time = time.time()
        bfs_solution = search_method.bfs(nodes[0], g_state)
        uniform_solution = search_method.uniform_cost_search(nodes[0], "023456781")
        end_time = time.time()

        # sequence of solution steps
        print("Here are your solution nodes: ")

        print("Search sequence with BFS: ")
        for solution_node in bfs_solution:
            print(solution_node)

        # Time for searching
        print("Searching took {}s with {} steps.".format((end_time - start_time), len(bfs_solution)))

        print("Search sequence with Uniform Cost Search: ")
        for uni_solution in uniform_solution:
            print(uni_solution)

        print("Searching took {}s with {} steps.".format((end_time - start_time), len(uniform_solution)))
