class Search:
    def __init__(self):
        self.frontier = []
        self.explored = []

    def bfs(self, root_node, goal_state):
        """
        This method performs breadth first search on a given set of
        vertices over a graph.

        :param root_node: A Node from which the search should start.
        :param goal_state: The final state to be searched using BFS.
        :return: The sequence of iterated nodes during the search.
        """

        # start by checking out the root node
        self.frontier.append(root_node)
        root_node.set_visited(True)

        # continue to explore as long as the frontier is not empty
        while len(self.frontier) != 0:
            popped_state = self.frontier.pop(0)
            self.explored.append(popped_state)

            # when a solution is found, return the set of
            # explored nodes.
            if popped_state.get_state() == goal_state:
                return self.explored

            for neighbour in popped_state.get_neighbours():
                if (neighbour not in self.explored) and (not neighbour.is_visited()):
                    self.frontier.append(neighbour)
                    neighbour.set_visited(True)

        # return a failure when the solution node is not found.
        raise Exception("Sorry! Couldn't find your goal state.")

    def uniform_cost_search(self, root_node, goal_state):
        """
        This method performs uniform cost search on a given set of
        vertices over a graph.

        :param root_node:
        :param goal_state:
        :return: the least cost search
        """

        self.frontier.append(root_node)
        root_node.set_visited(True)

        while len(self.frontier) != 0:
            popped_state = self.frontier.pop(0)

            # when a solution is found, return the set of
            # explored nodes.
            if popped_state.get_state() == goal_state:
                return self.explored

            for neighbour in popped_state.get_neighbours():
                if (neighbour not in self.explored) and (not neighbour.is_visited()):
                    self.frontier.append(neighbour)
                    neighbour.set_visited(True)

                elif neighbour in self.frontier:
                    # get the index of where neighbour kind of object is, in the frontier
                    index = self.frontier.index(neighbour)
                    existing_neighbour = self.frontier[index]

                    # if neighbour is in frontier with higher path cost then
                    # replace that frontier node with neighbour
                    if neighbour.get_cost() > existing_neighbour.get_cost():
                        self.frontier[index] = neighbour

            # sort the frontier list based on their costs
            # so that when a node gets popped, its always the one
            # having the least cost.
            self.frontier = sorted(self.frontier)

        # return a failure when the solution node is not found.
        raise Exception("Sorry! Couldn't find your goal state.")
