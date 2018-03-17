class Node:
    """
    Created by Rakshith for CSC 512 HW2.

    This class is representative of a given state. A state is nothing but a particular
    sequence of number arrangement. Ex:

    |2|1|0|
    |3|4|5|
    |6|7|8|

    It is kind of like a board representation. The sequence of numbers are initialized by the constructor.
    The values of the state is encoded as a string. The previous example can be represented as
    "210345678", where 0 is a blank space.
    """

    def __init__(self, state):
        self.state = state
        self.visited = False
        self.neighbours = []
        self.cost = 0

    def get_state(self):
        return self.state

    def is_visited(self):
        return self.visited

    def add_neighbour(self, neighbour):
        self.neighbours.append(neighbour)

    def set_visited(self, truth):
        self.visited = truth

    def get_neighbours(self):
        return self.neighbours

    def preview_neighbours(self):
        print(self.neighbours)

    def set_cost(self, cost):
        self.cost = cost

    def get_cost(self):
        return self.cost

    def __str__(self):
        return self.state

    def __eq__(self, other):
        return isinstance(other, Node) and self.state == other.state

    def __lt__(self, other):
        return self.cost > other.cost

    def __gt__(self, other):
        return other.__lt__(self)
