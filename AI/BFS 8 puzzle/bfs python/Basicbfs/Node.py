class Node:
    def __init__(self, data):
        self.data = data
        self.neighbours = []
        self.visited = False

    def add_neighbour(self, neighbour):
        self.neighbours.append(neighbour)

    def preview_neighbours(self):
        print(self.neighbours)

    def get_neighbours(self):
        return self.neighbours

    def set_visited(self, truth):
        self.visited = truth

    def get_data(self):
        return self.data

    def is_visited(self):
        return self.visited

    def __eq__(self, other):
        return isinstance(other, Node) and self.data == other.data

    def __str__(self):
        return str(self.data)
