class BFS:
    def __init__(self):
        self.explored = []
        self.frontier = []

    def bfs(self, root, goal_value):
        self.frontier.append(root)
        root.set_visited(True)

        while len(self.frontier) != 0:
            popped_node = self.frontier.pop(0)
            self.explored.append(popped_node)

            if popped_node.get_data() == goal_value:
                return self.explored

            for neighbour in popped_node.get_neighbours():
                if (neighbour not in self.explored) and (not neighbour.is_visited()):
                    self.frontier.append(neighbour)
                    neighbour.set_visited(True)

        raise Exception("Couldn't find your goal.")
